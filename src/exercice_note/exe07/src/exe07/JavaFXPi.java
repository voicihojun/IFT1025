package exe07;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.Native;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFXPi extends Application {

    private Text result;
    private Button btn;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox root = new VBox();

        Scene scene = new Scene(root, 320, 280);

        Text logo = new Text("\u03c0");
        logo.setFont(Font.font(88));

        new AnimationTimer() {
            private double angle = 0;
            private long lastTime = 0;

            @Override
            public void handle(long now) {
                if (lastTime == 0) {
                    lastTime = now;
                    return;
                }

                long dt = now - lastTime;
                angle += 180 * dt * 1e-9;

                logo.setRotate(angle);
                lastTime = now;
            }
        }.start();


        result = new Text("");

        TextField pattern = new TextField();

        // ce code est activé quand je clique "enter"
        // j'ai changé ce code en utilisant Platform.runlater
//        pattern.setOnAction((event) -> {
//            search(pattern.getText());
//        });

        pattern.setOnAction((event) -> {
            Thread enter = new Thread(() -> {
                Platform.runLater(() -> {
                    search(pattern.getText());
                    System.out.println("111");
                });
            });
            enter.start();
        });




        Label patternLabel = new Label("Entrez une séquence de chiffres :");
        patternLabel.setLabelFor(pattern);

        btn = new Button("Rechercher");

        // ce code est activé quand je clique le bouton.
        // j'ai changé ce code en utilisant Platform.runlater
//        btn.setOnAction((event) -> {
//            search(pattern.getText());
//        });
        btn.setOnAction((event) -> {
            Thread button = new Thread(() -> {
                Platform.runLater(() -> {
                    search(pattern.getText());
                    System.out.println("222");
                });
            });
            button.start();
        });


        root.getChildren().addAll(logo, result, patternLabel, pattern, btn);
        root.setPadding(new Insets(10));
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);

        primaryStage.setTitle("Pi");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void search(String digits) {

        btn.setDisable(true);
        result.setText("Recherche en cours...");

        // j'ai ajouté un thread separé ici pour ne pas influencer l'interface graphique.
        Thread t = new Thread(()-> {
            boolean found = false;
            try {
                FileReader reader = new FileReader(new File("pi.txt"));

                int position = 0;

                int matching = 0;
                int val;

                while ((val = reader.read()) != -1) {
                    char c = (char) val;

                    if (matching == digits.length()) {
                        String text = "Séquence trouvée en position : " + (position - matching);
                        found = true;
                        result.setText(text);
                        break;
                    }

                    if (c == digits.charAt(matching)) {
                        matching++;
                    } else {
                        matching = 0;
                    }

                    position++;
                }

                if (!found) {
                    result.setText("Chiffres introuvables");
                }

                btn.setDisable(false);

                reader.close();
            } catch (IOException ex) {
                System.out.println("Erreur d'entrée/sortie, vérifiez que le fichier");
            }
        });
        t.start();
    }
}
