package exercice_note.exe06;

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
    public void interagir(Robot robot) {
        System.out.println("You found kitten! Way to go, robot.\n" +
                name + " <3 " + robot.getName());
        System.exit(0);
    }


}
