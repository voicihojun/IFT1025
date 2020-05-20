package exe06;


import javafx.scene.image.Image;

public class Robot {
    private int nombreCle;
    private String name;
    private boolean avoirTeleporteur;
    private Point point;
    private char representation;

    public Robot(String name, Point point) {
        this.name = name;
        this.point = point;
        this.nombreCle = 0;
        this.avoirTeleporteur = false;
        this.representation = '#';
    }

    public int getNombreCle() {
        return nombreCle;
    }

    public void setNombreCle(int nombreCle) {
        this.nombreCle = nombreCle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvoirTeleporteur() {
        return avoirTeleporteur;
    }

    public void setAvoirTeleporteur(boolean avoirTeleporteur) {
        this.avoirTeleporteur = avoirTeleporteur;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public char getRepresentation() {
        return representation;
    }

    public void setRepresentation(char representation) {
        this.representation = representation;
    }

    public String getPossessionTeleporteur() {
        if(avoirTeleporteur) {
            return "T";
        } else {
            return "";
        }
    }
}
