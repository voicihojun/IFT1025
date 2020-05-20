package exercice_note.exe06;

public class Cle extends Case {

    public Cle() {
        this.representation = '\'';
    }

    @Override
    public boolean interactionPossible(Robot robot) {
        return true;
    }

    @Override
    public void interagir(Robot robot) {
        int nombreCle = robot.getNombreCle();
        robot.setNombreCle(nombreCle + 1);
    }
}
