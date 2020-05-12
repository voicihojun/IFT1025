package projet.projet01;

public class Teleporteur extends NonKitten {
    public Teleporteur(char representation) {
        super(representation);
    }

    @Override
    public boolean interactionPossible(Robot robot) {
        return true;
    }

    @Override
    public void interagir(Robot robot) {
        robot.setAvoirTeleporteur(true);
    }
}

