package exercice_note.exe03;

public class Vecteur {
    private double[] elements;

    // constructeur avec en paramètre un tableau d'éléments de type `double`
    public Vecteur(double[] elements) {
        this.elements = new double[elements.length];
        for(int i=0; i < elements.length; i++) {
            this.elements[i] = elements[i];
        }
    }

    //permet de changer la valeur à l'index donné (commence à 0, comme pour un tableau)
    public void setElement(int index, double valeur) {
        this.elements[index] = valeur;
    }

    // accès à la valeur à l'élément donné
    public double getElement(int index) {
        return this.elements[index];
    }

    // retourne le produit scalaire avec un autre vecteur
    public double dotProduct(Vecteur v) {
        double result = 0;
        if (this.elements.length != v.elements.length) {
            System.err.println("The length of two vecteurs is not same!");
            return 0/0;
        } else {
            for(int i=0; i < elements.length; i++) {
                result += elements[i] * v.elements[i];
            }
        }
        return result;

    }

    // affiche le contenu du vecteur entres accolades {  }
    public void afficher() {
        String result = "{";
        for(int i=0; i < this.elements.length; i++) {
            if(i == this.elements.length - 1) {
                result += this.elements[i] + "}";
            } else {
                result += this.elements[i] + ", ";
            }
        }
        System.out.println(result);
    }
}
