package model;

import controller.Controleur;
import model.Case;

public class Grille {
    private Case[][] grille;
    private int largeur;
    private int hauteur;
    private int hauteurPiece;
    private int largeurPiece;
    private int nbrPiecesY;
    private int nbrPiecesX;
    private int nbrNonKitten;
    private Robot robot;

    public Grille(int nbrPiecesX, int nbrPiecesY, int largeurPiece, int hauteurPiece, int nbrNonKitten) {
        this.largeur = nbrPiecesX * largeurPiece + 1;
        this.hauteur = nbrPiecesY * hauteurPiece + 1;
        this.hauteurPiece = hauteurPiece;
        this.largeurPiece = largeurPiece;
        this.grille = new Case[hauteur][largeur];
        this.nbrPiecesX = nbrPiecesX;
        this.nbrPiecesY = nbrPiecesY;
        this.nbrNonKitten = nbrNonKitten;

        remplirMurEmptyPorte();
        remplirCle();
        remplirNonKitten();

        this.robot = new Robot("hojun", randomEmptyCell());
        afficher(robot);
    }


    public Point randomEmptyCell() {
        Point point = null;
        boolean flag = false;
        int randomX = 0;
        int randomY = 0;

        while(!flag) {
            randomX = (int)(Math.random() * this.largeur);
            randomY = (int)(Math.random() * this.hauteur);
            if(grille[randomY][randomX] instanceof Empty) {
                point = new Point(randomX, randomY);
                flag = true;
            }
        }
        return point;
    }


    public void remplirMurEmptyPorte() {
        for(int i=0; i < hauteur; i++) {
            for(int j=0; j < largeur; j++) {
                if(i==0 || j==0 || i==hauteur-1 || j==largeur-1) {
                    grille[i][j] = new Mur();
                } else if(i % hauteurPiece == 0 || j % largeurPiece == 0) {
                    if(i % hauteurPiece == (hauteurPiece/2) || j % largeurPiece == (largeurPiece/2)) {
                        grille[i][j] = new Porte();
                    } else {
                        grille[i][j] = new Mur();
                    }

                } else {
                    grille[i][j] = new Empty();
                }
            }
        }
    }

    public void remplirCle() {
        for(int i=0; i < nbrPiecesY; i++) {
            for(int j=0; j < nbrPiecesX; j++) {
                boolean flag = false;
                while(!flag) {
                    int randomX = (int)(Math.random() * largeurPiece + 1) + largeurPiece * j;
                    int randomY = (int)(Math.random() * hauteurPiece + 1) + hauteurPiece * i;
                    if(grille[randomY][randomX] instanceof Empty) {
                        grille[randomY][randomX] = new Cle();
                        flag = true;
                    }
                }
            }
        }
    }

    public void remplirNonKitten() {
        for(int i=0; i < nbrNonKitten; i++) {
            Point point = randomEmptyCell();
            if(i==0) {
                grille[point.getY()][point.getX()] = new Kitten("irene");
            } else if(i==1) {
                grille[point.getY()][point.getX()] = new Teleporteur();
            } else {
                grille[point.getY()][point.getX()] = new NonKitten();
            }
        }
    }

    public void afficher(Robot robot) {
        String result = "";
        for(int i=0; i < hauteur; i++) {
            for(int j=0; j < largeur; j++) {
                if(this.robot.getPoint().getX() == j && this.robot.getPoint().getY() == i) {
                    result += "#";
                } else {
                    result += grille[i][j].getRepresentation();
                }

            }
            result += "\n";
        }
        System.out.println(result);
    }


    public Robot getRobot() {
        return robot;
    }

    public boolean deplacementPossible(Robot robot, int x, int y) {
        Case c = grille[y][x];
        return c.interactionPossible(robot);
    }

//    public void interagir(model.Robot robot) {
//        if(grille[robot.getPoint().getY()][robot.getPoint().getX()].interactionPossible(robot)) {
//            grille[robot.getPoint().getY()][robot.getPoint().getX()].interagir(robot);
//        }
//    }

    public void interagir(Robot robot, Controleur c) {
        if(grille[robot.getPoint().getY()][robot.getPoint().getX()].interactionPossible(robot)) {
            grille[robot.getPoint().getY()][robot.getPoint().getX()].interagir(robot, c);
        }
    }


//    public void moveRobot(model.Robot robot, int x, int y) {
//        if(deplacementPossible(robot, x, y)) {
//            model.Point point = new model.Point(x, y);
//            robot.setPoint(point);
//
//            if(grille[y][x] instanceof model.Cle || grille[y][x] instanceof model.Porte || grille[y][x] instanceof model.Teleporteur) {
//                interagir(robot);
//                grille[y][x] = new model.Empty();
//            } else {
//                interagir(robot);
//            }
//        }
//    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public Case[][] getGrille() {
        return grille;
    }
}
