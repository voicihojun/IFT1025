package controller;

import javafx.stage.Stage;
import model.Grille;
import model.Robot;
import view.View;

public class Controleur {
    private View view;
    private Grille grille;
    private Robot robot;

    public Controleur() {
        this.view = new View();
        this.grille = new Grille(3,2,6,4,10);
        this.robot = grille.getRobot();

    }

    public void afficherImage(Stage stage, String description) {
        view.afficherImage(stage, this, description, grille, robot);
    }

    public void setKittenDescription(String kittenDescription) {
        view.setKittenDescription(kittenDescription);
    }

    public void setDescription(String description) {
        view.setDescription(description);
    }
}
