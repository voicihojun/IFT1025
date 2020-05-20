package model;

import controller.Controleur;

public class Kitten extends Case {
    private String name;
    private String imagePath;

    public Kitten(String name) {
        this.name = name;
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
        String kittenDescription = "You found kitten! Way to go, robot.\n" +
                name + " <3 " + robot.getRobotName();
        c.setKittenDescription(kittenDescription);
    }
}