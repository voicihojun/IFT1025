package model;

import controller.Controleur;

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
