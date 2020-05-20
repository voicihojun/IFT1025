package exe06;


import exe06.*;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.HashMap;

public class Grille {
    private int nbrPieceX;
    private int nbrPieceY;
    private int largeurPiece;
    private int hauteurPiece;
    private int nbrNonKitten;
    private Case[][] grille;
    private int largeur;
    private int hauteur;
    private HashMap<Character, String> map = new HashMap<>();

    public Grille(int nbrPieceX, int nbrPieceY, int nbrNonKitten, int largeurPiece, int hauteurPiece) {
        this.nbrPieceX = nbrPieceX;
        this.nbrPieceY = nbrPieceY;
        this.nbrNonKitten = nbrNonKitten;
        this.largeurPiece = largeurPiece;
        this.hauteurPiece = hauteurPiece;
        this.largeur = largeurPiece * nbrPieceX + 1;
        this.hauteur = hauteurPiece * nbrPieceY + 1;
        this.grille = new Case[hauteur][largeur];
        fabriquerGrille();
    }

    public void fabriquerGrille() {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                if (j == 0 || j == largeur - 1 || i == 0 || i == hauteur - 1) {
                    grille[i][j] = new Mur();
                } else if (j % ((largeur - 1) / nbrPieceX) == 0 || i % ((hauteur - 1) / nbrPieceY) == 0) {
                    if(i % (hauteurPiece/2) == 0 && i % hauteurPiece != 0 && i != 0 && i != hauteur-1) {
                        grille[i][j] = new Porte();
                    } else if(j % (largeurPiece/2) == 0 && j % largeurPiece != 0 && j != 0 && j != largeur-1){
                        grille[i][j] = new Porte();
                    } else {
                        grille[i][j] = new Mur();
                    }
                } else {
                    grille[i][j] = new Empty();
                }
            }
        }

        for(int i=0; i < nbrPieceY; i++) {
            for(int j=0; j < nbrPieceX; j++) {
                boolean flag = true;
                while(flag) {
                    int randomX = (int)(Math.random() * largeurPiece) + (largeurPiece * j);
                    int randomY = (int)(Math.random() * hauteurPiece) + (hauteurPiece * i);
                    if(grille[randomY][randomX] instanceof Empty) {
                        grille[randomY][randomX] = new Cle();
                        flag = false;
                    }
                }
            }
        }

        for (int i = 0; i < this.nbrNonKitten; i++) {
            int x = randomEmptyCell().getX();
            int y = randomEmptyCell().getY();

            if(i == 0) {
                grille[y][x] = new Kitten(Case.getRandomSymbole());
            } else if(i == 1) {
                grille[y][x] = new Teleporteur(Case.getRandomSymbole());
            } else {
                char randomSymbole = Case.getRandomSymbole();
                grille[y][x] = new NonKitten(randomSymbole);
            }
        }
    }

    //Retourne une coordonnée de cellule qui ne contient rien
    public Point randomEmptyCell() {
        ArrayList<Point> pointList = new ArrayList<>();
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                if (grille[i][j] instanceof Empty) {
                    pointList.add(new Point(j, i));
                }
            }
        }
        int random = (int) (Math.random() * pointList.size());
        return pointList.get(random);
    }

    //indique si c’est possible pour le robot robot de marcher sur la cellule de coordonnée (x, y)
    public boolean deplacementPossible(Robot robot, int x, int y) {
        if(grille[y][x] instanceof Mur) {
            return false;
        } else if(grille[y][x] instanceof Porte) {
            if(robot.getNombreCle() <= 0) {
                return false;
            }
        }
        return true;
    }

    //Affiche la grille dans la console à coups de System.out.println(...)
    public void afficher(Robot robot) {
        String result = "";
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                if (robot.getPoint().getX() == j && robot.getPoint().getY() == i) {
                    result += "#";
                } else {
                    result += grille[i][j].getRepresentation();
                }
            }
            result += "\n";
        }
        System.out.println(result);
    }


    //Lance l’interaction entre le Robot robot et la case de la grille sur laquelle il se trouve
    public void interagir(Robot robot, Controleur c) {
        grille[robot.getPoint().getY()][robot.getPoint().getX()].interagir(robot, c);
    }

//    void interagir(Robot robot, Controleur c) {
//
//        Case positionPresent = grille[robot.getPosition().getY()][robot.getPosition().getX()];
//
//        if (positionPresent instanceof NonKitten) {
//            ((NonKitten) positionPresent).setDescription(positionPresent.getRepresentation());
//            positionPresent.interagir(robot, c);
//
//        } else if (positionPresent instanceof Case) {
//            positionPresent.interagir(robot, c);
//
//        }
//    }

    public Case getCase(int x, int y) {
        return grille[y][x];
    }

    public void setCase(int x, int y, Case newCase) {
        grille[y][x] = newCase;
    }

    public int getLargeur() {
        return this.largeur;
    }

    public int getHauteur() {
        return this.hauteur;
    }

    public Case[][] getGrille() {
        return this.grille;
    }
}