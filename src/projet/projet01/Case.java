package projet.projet01;

public abstract class Case {
    protected char representation;

    public char getRepresentation() {
        return representation;
    }

    public abstract boolean interactionPossible(Robot robot);

    public abstract void interagir(Robot robot);


    public static char getRandomSymbole() {
        return (char) (Math.random() * (126 - 58) + 58);
    }
}
