package exe06;

import javafx.scene.image.Image;

public class Kitten extends NonKitten {
    private String name = "Caramel";
    public Kitten(char representation) {
        super(representation);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean interactionPossible(Robot robot) {
        return true;
    }

    @Override
    public void interagir(Robot robot, Controleur c) {
        String kittenDescription = "You found Kitten! Way to go, robot.\n"  + " <3 " + robot.getName();
        c.setKitten(kittenDescription);

        System.out.println("You found kitten! Way to go, robot.\n" +
                name + " <3 " + robot.getName());
        System.exit(0);
    }


}
