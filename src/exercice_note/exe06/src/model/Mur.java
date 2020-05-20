package model;

import controller.Controleur;

public class Mur extends Case {

    public Mur() {
        this.representation = '%';
    }

    @Override
    public boolean interactionPossible(Robot robot) {
        return false;
    }

    @Override
    public void interagir(Robot robot, Controleur c) {

    }
}
