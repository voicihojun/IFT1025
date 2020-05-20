package exe06;

import javafx.scene.image.Image;

public class Cle extends Case {

    public Cle() {
        this.representation = '\'';
    }

    @Override
    public boolean interactionPossible(Robot robot) {
        return true;
    }

    @Override
    public void interagir(Robot robot, Controleur c) {
        int nombreCle = robot.getNombreCle();
        robot.setNombreCle(nombreCle + 1);
        c.setRobot(robot);
    }

}
