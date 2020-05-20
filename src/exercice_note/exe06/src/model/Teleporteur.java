package model;

import controller.Controleur;

public class Teleporteur extends Case {

    private String imagePath;

    public Teleporteur() {
        this.representation = getRandomSymbole();
        this.imagePath = getRandomImage();
    }

    public String getRandomImage() {
        int num = (int)(Math.random() * 82) + 1;
        return "/images/nki/" + num + ".png";
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public boolean interactionPossible(Robot robot) {
        return true;
    }

    @Override
    public void interagir(Robot robot, Controleur c) {
        robot.setPossessionT(true);
    }
}
