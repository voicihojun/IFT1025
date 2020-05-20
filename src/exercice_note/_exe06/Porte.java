package exercice_note.exe06;

public class Porte extends Case {
    public Porte() {
        this.representation = '!';
    }


    @Override
    public boolean interactionPossible(Robot robot) {
        if(robot.getNombreCle() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void interagir(Robot robot) {
        int nbrCle = robot.getNombreCle();
        robot.setNombreCle(nbrCle - 1);

    }
}
