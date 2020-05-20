package main;

import controller.Controleur;
import javafx.application.Application;
import javafx.stage.Stage;

public class RobotFindsKitten extends Application {

    public static void main(String[] args) {
        RobotFindsKitten.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String description = "Bienvenue dans main.RobotFindsKitten Super Dungeon Master 3000 Ultra Turbo Edition !";
        Controleur c = new Controleur();
        c.afficherImage(stage, description);
    }
}
