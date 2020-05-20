package model;

import controller.Controleur;
import model.Case;

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
        int nbrCle = robot.getNbrCle();
        robot.setNbrCle(nbrCle + 1);
    }
}
