package exe06;

import javafx.scene.image.Image;

public class Empty extends Case {
    public Empty() {
        this.representation = ' ';
    }

    @Override
    public boolean interactionPossible(Robot robot) {
        return true;
    }

    @Override
    public void interagir(Robot robot, Controleur c) {

    }


}
