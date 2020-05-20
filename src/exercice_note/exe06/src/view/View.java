package view;

import controller.Controleur;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;
import main.*;


public class View {
    private int robotX;
    private int robotY;
    private Robot robot;
    private boolean isFound = false;
    private Text robotName;
    private Text textDescription;
    private Stage stage;
    private Grille grille;
    private GridPane gridPane;
    private ImageView[][] imageViews;
    private String kittenDescription;
    private String description;
    private Controleur c;


    public void afficherImage(Stage stage, Controleur c, String description, Grille grille, Robot robot) {
        this.stage = stage;
        this.grille = grille;
        this.robotX = robot.getPoint().getX();
        this.robotY = robot.getPoint().getY();
        this.robot = robot;
        this.description = description;
        this.c = c;

        VBox root = new VBox();
        Scene scene = new Scene(root, Color.BLACK);

        textDescription = new Text(description);
        textDescription.setFill(Color.WHITE);
        root.getChildren().add(textDescription);

        gridPane = new GridPane();

        root.getChildren().add(gridPane);
        gridPane.setAlignment(Pos.CENTER);



        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case W:
                        robotX = robot.getPoint().getX();
                        robotY = robot.getPoint().getY() - 1;
                        break;
                    case A:
                        robotX = robot.getPoint().getX() - 1;
                        robotY = robot.getPoint().getY();
                        break;
                    case S:
                        robotX = robot.getPoint().getX();
                        robotY = robot.getPoint().getY() + 1;
                        break;
                    case D:
                        robotX = robot.getPoint().getX() + 1;
                        robotY = robot.getPoint().getY();
                        break;
                    case T:
                        if (robot.getPossessionT()) {
                            Point point = grille.randomEmptyCell();
                            robotX = point.getX();
                            robotY = point.getY();
                        }
                        break;
                    case F5:
                        stage.setFullScreen(!stage.isFullScreen());
                        break;
                    case ESCAPE:
                        stage.close();
                        break;
                    default:
                        robotX = robot.getPoint().getX();
                        robotY = robot.getPoint().getY();
                        break;
                }
                if (grille.deplacementPossible(robot, robotX, robotY)) {
                    moveRobot(robot, c);
                }

            }
        });

        robotName = new Text(robot.getRobotName() + " [" + robot.getNbrCle() + "]" + robot.returnPossessionT() + ">");
        robotName.setFill(Color.WHITE);
        makeImage();

        gridPane.prefHeightProperty().bind(root.prefHeightProperty());
        gridPane.prefWidthProperty().bind(root.prefWidthProperty());

        root.getChildren().add(robotName);
        root.setAlignment(Pos.CENTER);

        stage.setTitle("main.RobotFindsKitten");
        stage.setScene(scene);
        stage.show();

    }

    public void makeImage() {
        if(isFound) {
            VBox root = new VBox();
            Scene scene = new Scene(root);
            Image foundKittenImg = new Image("/images/found-kitten.png");
            ImageView foundKittenView = new ImageView(foundKittenImg);

            root.getChildren().add(foundKittenView);

            robotName = new Text(kittenDescription);

            root.getChildren().add(robotName);
            root.setAlignment(Pos.CENTER);

            stage.setScene(scene);
            stage.show();

            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    if (keyEvent.getCode() == KeyCode.SPACE) {
                        RobotFindsKitten r = new RobotFindsKitten();
                        try {
                            r.start(stage);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

        } else {
            textDescription.setText(this.description);
            VBox root = new VBox();
            Scene scene = new Scene(root);
            imageViews = new ImageView[grille.getHauteur()][grille.getLargeur()];

            Image imgBack = new Image("/images/back.png");
            Image imgDoor = new Image("/images/door.png");
            Image imgKey = new Image("/images/key.png");
            Image imgRob = new Image("/images/rob.png");
            Image imgWall = new Image("/images/wall.png");

            ImageView iv;

            for(int i=0; i < grille.getLargeur(); i++) {
                for(int j=0; j < grille.getHauteur(); j++) {

                    Case imgCase = grille.getGrille()[j][i];
                    iv = new ImageView();
                    imageViews[j][i] = iv;

                    if(imgCase instanceof Mur) {
                        iv.setImage(imgWall);
                    } else if(imgCase instanceof Porte) {
                        iv.setImage(imgDoor);
                    } else if(imgCase instanceof Cle) {
                        iv.setImage(imgKey);
                    } else if(imgCase instanceof Empty) {
                        iv.setImage(imgBack);
                    } else if(imgCase instanceof Kitten) {
                        iv.setImage(new Image(((Kitten) imgCase).getImagePath()));
                    } else if(imgCase instanceof Teleporteur) {
                        iv.setImage(new Image(((Teleporteur) imgCase).getImagePath()));
                    } else if(imgCase instanceof NonKitten) {
                        iv.setImage(new Image(((NonKitten) imgCase).getImagePath()));
                    }

                    if(robotX == i && robotY == j) {
                        iv.setImage(imgRob);
                    }

//                    iv.setFitHeight(30);
//                    iv.setFitWidth(30);
//                    iv.setPreserveRatio(true);
                    iv.setFitHeight(30);
                    iv.setFitWidth(30);



                    gridPane.add(iv, i, j);
                }
            }

            robotName.setText(robot.getRobotName() + " [" + robot.getNbrCle() + "]" + robot.returnPossessionT() + ">");
        }
    }

    public void moveRobot(Robot robot, Controleur c) {
        Point point = new Point(robotX, robotY);
        robot.setPoint(point);
        grille.interagir(robot, c);

        if(grille.getGrille()[robotY][robotX] instanceof Cle || grille.getGrille()[robotY][robotX] instanceof Porte ||
                grille.getGrille()[robotY][robotX] instanceof Teleporteur) {
            grille.getGrille()[robotY][robotX] = new Empty();
        } else if(grille.getGrille()[robotY][robotX] instanceof Kitten){
            isFound = true;
        }

        makeImage();
    }

    public void setKittenDescription(String kittenDescription) {
        this.kittenDescription = kittenDescription;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
