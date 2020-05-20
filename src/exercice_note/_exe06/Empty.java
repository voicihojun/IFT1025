package exercice_note.exe06;

public class Empty extends Case {
    public Empty() {
        this.representation = ' ';
    }

    @Override
    public boolean interactionPossible(Robot robot) {
        return true;
    }

    @Override
    public void interagir(Robot robot) {

    }
}
