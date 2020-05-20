package exercice_note.exe06;


import java.util.Scanner;

public class RobotFindsKitten {
    public static void main(String args[]) {
        System.out.println("Bienvenue dans RobotFindsKitten\n" +
                "Super Dungeon Master 3000 Ultra Turbo Edition !\n");

        Grille grille = new Grille(5,2,10,12,6);
        Robot robot = new Robot("hojun", grille.randomEmptyCell());
        grille.afficher(robot);
        System.out.print(robot.getName() + "[" + robot.getNombreCle() + "]>  ");
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while(flag) {
            String next = scanner.nextLine().trim().toLowerCase();
            Point point = null;
            int x, y = 0;
            switch(next) {
                case "w":
                    y = robot.getPoint().getY() - 1;
                    x = robot.getPoint().getX();
                    if(grille.getCase(x, y).interactionPossible(robot)) {
                        point = new Point(x, y);
                        robot.setPoint(point);
                        if(grille.getCase(x, y) instanceof Cle || (grille.getCase(x, y) instanceof Porte)) {
                            grille.interagir(robot);
                            grille.setCase(x, y, new Empty());
                        } else {
                            grille.interagir(robot);
                        }
                    }
                    break;

                case "a":
                    y = robot.getPoint().getY();
                    x = robot.getPoint().getX() - 1;
                    if(grille.getCase(x, y).interactionPossible(robot)) {
                        point = new Point(x, y);
                        robot.setPoint(point);
                        if(grille.getCase(x, y) instanceof Cle || (grille.getCase(x, y) instanceof Porte)) {
                            grille.interagir(robot);
                            grille.setCase(x, y, new Empty());
                        } else {
                            grille.interagir(robot);
                        }
                    }
                    break;

                case "s":
                    y = robot.getPoint().getY() + 1;
                    x = robot.getPoint().getX();
                    if(grille.getCase(x, y).interactionPossible(robot)) {
                        point = new Point(x, y);
                        robot.setPoint(point);
                        if(grille.getCase(x, y) instanceof Cle || (grille.getCase(x, y) instanceof Porte)) {
                            grille.interagir(robot);
                            grille.setCase(x, y, new Empty());
                        } else {
                            grille.interagir(robot);
                        }
                    }
                    break;

                case "d":
                    y = robot.getPoint().getY();
                    x = robot.getPoint().getX() + 1;
                    if(grille.getCase(x, y).interactionPossible(robot)) {
                        point = new Point(x, y);
                        robot.setPoint(point);
                        if(grille.getCase(x, y) instanceof Cle || (grille.getCase(x, y) instanceof Porte)) {
                            grille.interagir(robot);
                            grille.setCase(x, y, new Empty());
                        } else {
                            grille.interagir(robot);
                        }
                    }
                    break;

                case "t":
                    if(robot.isAvoirTeleporteur()) {
                        point = grille.randomEmptyCell();
                        robot.setPoint(point);
                    }
                    break;
            }

            grille.afficher(robot);
            if(robot.isAvoirTeleporteur()) {
                System.out.print(robot.getName() + "[" + robot.getNombreCle() + "]T>  ");
            } else {
                System.out.print(robot.getName() + "[" + robot.getNombreCle() + "]>  ");
            }
        }
    }
}
