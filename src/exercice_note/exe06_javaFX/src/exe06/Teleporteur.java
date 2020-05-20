package exe06;

import javafx.scene.image.Image;

public class Teleporteur extends NonKitten {
    public Teleporteur(char representation) {
        super(representation);
    }

    @Override
    public boolean interactionPossible(Robot robot) {
        return true;
    }

    @Override
    public void interagir(Robot robot, Controleur c) {
        robot.setAvoirTeleporteur(true);
        c.setRobot(robot);
    }
}

