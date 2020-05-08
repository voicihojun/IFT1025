package exercice_note.exe03;

public class Matrice {
    private double[][] matrice;
    private int lignes;
    private int cols;

    // constructeur pour une matrice de taille Nlignes x Ncolonnes (remplie de zéros)
    public Matrice(int lignes, int cols) {
        this.matrice = new double[lignes][cols];
        this.lignes = lignes;
        this.cols = cols;
    }

    // additionne un scalaire dans toutes les cellules de la matrice (ça modifie donc la matrice)
    public void additionnerScalaire(double n) {
        for(int i=0; i < this.lignes; i++) {
            for(int j=0; j < this.cols; j++) {
                matrice[i][j] += n;
            }
        }
    }

    // multiplie toutes les cellules par un scalaire (ça modifie également la matrice)
    public void multiplierScalaire(double n) {
        for(int i=0; i < this.lignes; i++) {
            for(int j=0; j < this.cols; j++) {
                matrice[i][j] *= n;
            }
        }
    }

    // fait le produit matriciel entre deux matrices (crée une *nouvelle matrice* de la bonne taille,
    // ne modifie pas les deux matrices originales)
    public Matrice dotProduct(Matrice m) {
        if(this.cols != m.lignes) {
            System.err.println("[ "+this.lignes+ ", "+this.cols+" ] X [ "
                    + m.lignes +", "+ m.cols + " ] est non valide!" );
            return null;
        } else {
            Matrice new_matrice = new Matrice(this.lignes, m.cols);
            for(int i=0; i < new_matrice.lignes; i++) {
                for(int j=0; j < new_matrice.cols; j++) {
                    new_matrice.setCell(i, j, getLine(i).dotProduct(m.getCol(j)));
                }
            }
            return new_matrice;
        }

    }

    // accesseur pour la cellule à une ligne/colonne donnée
    public double getCell(int ligne, int col) {
        return this.matrice[ligne][col];
    }

    // mutateur pour la cellule à une ligne/colonne donnée
    public void setCell(int ligne, int col, double valeur) {
        this.matrice[ligne][col] = valeur;
    }

    //retourne la Nième ligne sous forme d'un vecteur
    public Vecteur getLine(int ligne) {
        double[] row = new double[this.cols];
        for(int i=0; i < row.length; i++) {
            row[i] = getCell(ligne, i);
        }
        return new Vecteur(row);
    }

    // retourne la Nième colone sous forme d'un vecteur
    public Vecteur getCol(int col) {
        double[] column = new double[this.lignes];
        for(int i=0; i < column.length; i++) {
            column[i] = getCell(i, col);
        }
        return new Vecteur(column);
    }

    //affiche la matrice sur la console
    public void afficher() {
        String result = "[ ";
        for(int i=0; i < this.lignes; i++) {
            if(i !=0 ) {
                result += "[ ";
            }
            for(int j=0; j < this.cols; j++) {
                if(j == this.cols - 1 && i != this.lignes - 1) {
                    result += getCell(i,j) + " ]\n";
                } else {
                    result += getCell(i,j) + " ";
                }
            }
        }
        result += " ]";
        System.out.println(result);
    }

    // retourne une instance de la matrice identité N x N
    public static Matrice identite(int n) {
        Matrice identite = new Matrice(n,n);

        for(int i=0; i < n; i++) {
            for(int j=0; j < n; j++) {
                if(i==j) {
                    identite.setCell(i,j,1);
                }
            }
        }
        return identite;
    }
}
