package exe06;

import javafx.scene.image.Image;

public abstract class Case {
    protected char representation;


    public char getRepresentation() {
        return representation;
    }

    public abstract boolean interactionPossible(Robot robot);

    public abstract void interagir(Robot robot, Controleur c);

    public static char getRandomSymbole() {
        return (char) (Math.random() * (126 - 58) + 58);
    }

//    public static String getRandomImagePath() {
//        int randNum = (int)(Math.random() * 82) + 1;
//        return "/images/nki/" + randNum + ".png";
//    }


}
