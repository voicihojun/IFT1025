package exe06;

import javafx.stage.Stage;

public class Controleur {
    private View view;
    private Stage primaryStage;
    private Grille grille;
    private Point point;
    private Robot robot;
//    private int robotX;
//    private int robotY;

    public Controleur() {
        this.view = new View();
        this.grille = new Grille(3,2, 10, 6, 4);
        this.point = grille.randomEmptyCell();
        this.robot = new Robot("hojun", point);
        this.grille.afficher(robot);
    }

    public void afficherImage(Stage primaryStage, String description) {
        view.afficherImage(primaryStage, this, description, grille, robot);
    }

    public void setDescription(String description) {
        view.setDescription(this, description);
    }

    public void setKitten(String kittenDescription) {
        view.setKitten(kittenDescription);
    }

    public void setRobot(Robot robot) {
        view.setRobot(robot);
    }

}
