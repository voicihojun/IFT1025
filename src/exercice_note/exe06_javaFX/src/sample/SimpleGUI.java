package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SimpleGUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = new VBox();
        Scene scene = new Scene(root, 320, 250);

        Text text = new Text("Hello World");
        Font font = new Font("serif", 25);
        text.setFont(font);
        root.getChildren().add(text);

        primaryStage.setTitle("Titre de la fenêtre");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
