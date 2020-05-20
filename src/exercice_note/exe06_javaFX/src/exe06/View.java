package exe06;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View {
    private static Grille grille;
    private Robot robot;
    private ImageView[][] imageViews;
    private GridPane grid;
    private Stage primaryStage;
    private VBox root;
    private Text robotName;
    private Text texte;
    private Scene scene;
    private Point point;
    private int robotX;
    private int robotY;
    private String description;
    private String kittenDescription;
    private Boolean isFound;

    public void afficherImage(Stage primaryStage, Controleur c, String description, Grille grille, Robot robot) {
        this.primaryStage = primaryStage;
        this.grille = grille;
        this.robot = robot;
        this.robotX = robot.getPoint().getX();
        this.robotY = robot.getPoint().getY();
        this.isFound = false;
        this.description = description;

        root = new VBox();
        scene = new Scene(root);

        texte = new Text(description);
        root.getChildren().add(texte);

        imageViews = new ImageView[grille.getLargeur()][grille.getHauteur()];

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        root.getChildren().add(grid);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent) {
                switch(keyEvent.getCode()) {
                    case W:
                        robotX = robot.getPoint().getX();
                        robotY = robot.getPoint().getY() - 1;
                        break;
                    case A:
                        robotX = robot.getPoint().getX()-1;
                        robotY = robot.getPoint().getY();
                        break;
                    case S:
                        robotX = robot.getPoint().getX();
                        robotY = robot.getPoint().getY()+1;
                        break;
                    case D:
                        robotX = robot.getPoint().getX()+1;
                        robotY = robot.getPoint().getY();
                        break;
                    case T:
                        if(robot.isAvoirTeleporteur()) {
                            robotX = grille.randomEmptyCell().getX();
                            robotY = grille.randomEmptyCell().getY();
                        }
                        break;
                    case F5:
                        primaryStage.setMaximized(true);
                        break;
                    case ESCAPE:
                        primaryStage.close();
                        break;
                    default :
                        robotX = robot.getPoint().getX();
                        robotY = robot.getPoint().getY();
                        break;
                }

                moveRobot(robot, c);
            }
        });

        robotName = new Text(robot.getName() + " [" + robot.getNombreCle() + "]" + robot.getPossessionTeleporteur() + ">");

        makeImage();

        root.getChildren().add(robotName);
        root.setAlignment(Pos.CENTER);

        primaryStage.setTitle("RobotFindsKitten");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void makeImage() {
        if(isFound) {
            root = new VBox();
            scene = new Scene(root);

            Image splashImg = new Image("/found-kitten.png");

            ImageView splashViewer = new ImageView(splashImg);

            root.getChildren().add(splashViewer);

            robotName = new Text(kittenDescription);

            root.getChildren().add(robotName);
            root.setAlignment(Pos.CENTER);

            primaryStage.setScene(scene);
            primaryStage.show();
        } else {
            texte.setText(this.description);

            Image imgBack = new Image("/back.png");
            Image imgDoor = new Image("/door.png");
            Image imgKey = new Image("/key.png");
            Image imgRob = new Image("/rob.png");
            Image imgWall = new Image("/wall.png");

            ImageView iv;

            for (int l=0;  l < grille.getLargeur(); l++) {
                for (int h=0; h < grille.getHauteur(); h++) {
                    Case imgCase = grille.getGrille()[h][l];

                    iv = new ImageView();
                    imageViews[l][h] = iv;

                    if (imgCase instanceof Cle) {
                        iv.setImage(imgKey);
                    } else if (imgCase instanceof Porte) {
                        iv.setImage(imgDoor);
                    } else if(imgCase instanceof Empty) {
                        iv.setImage(imgBack);
                    } else if (imgCase instanceof Mur) {
                        iv.setImage(imgWall);
                    } else if (imgCase instanceof NonKitten || imgCase instanceof Teleporteur )  {
                        Image imgRandom = new Image(((NonKitten) imgCase).getRandomImagePath());
                        iv.setImage(imgRandom);
                    }

                    if (l == robotX && h == robotY) {
                        iv.setImage(imgRob);
                    }

                    iv.setFitHeight(30);
                    iv.setFitWidth(30);
                    iv.setPreserveRatio(true);

                    grid.add(iv, l, h);

                }
            }
            robotName.setText(robot.getName() + " [" + robot.getNombreCle() + "] " + robot.getPossessionTeleporteur());
        }
    }

    private void moveRobot(Robot robot, Controleur c){
        if(grille.deplacementPossible(robot, robotX, robotY)) {
            isFound = false;

            point = new Point(robotX, robotY);
            robot.setPoint(point);
            grille.interagir(robot, c);

            if (grille.getCase(robotX, robotY) instanceof Cle ||
                    grille.getCase(robotX, robotY) instanceof Porte ||
                    grille.getCase(robotX, robotY) instanceof Teleporteur) {
                grille.setCase(robotX, robotY, new Empty());
            } else if (grille.getCase(robotX, robotY) instanceof Kitten) {
                isFound = true;
            }
            makeImage();
        } else {
            makeImage();
        }
    }

    public void setDescription(Controleur c, String description) {
        this.description = description;
    }

    public void setKitten(String kittenDescription) {
        this.kittenDescription = kittenDescription;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }


}
