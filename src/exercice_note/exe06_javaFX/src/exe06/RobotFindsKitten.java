package exe06;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Scanner;

public class RobotFindsKitten extends Application {
    private Stage primaryStage;

    public static void main(String args[]) {
        RobotFindsKitten.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        String description = "Bienvenue dans RobotFindsKitten Super Dungeon Master 3000 Ultra Turbo Edition !";
        Controleur c = new Controleur();
        c.afficherImage(primaryStage, description);
    }


}
