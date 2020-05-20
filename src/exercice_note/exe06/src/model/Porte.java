package model;

import controller.Controleur;

public class Porte extends Case {

    public Porte() {
        this.representation = '!';
    }

    @Override
    public boolean interactionPossible(Robot robot) {
        if(robot.getNbrCle() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void interagir(Robot robot, Controleur c) {
        int nbrCle = robot.getNbrCle();
        robot.setNbrCle(nbrCle - 1);
    }
}
