package model;

public class Robot {
    private String robotName;
    private Point point;
    private int nbrCle;
    private boolean possessionT;

    public Robot(String robotName, Point point) {
        this.robotName = robotName;
        this.point = point;
        this.nbrCle = 0;
        this.possessionT = false;
    }

    public String getRobotName() {
        return robotName;
    }

    public void setRobotName(String robotName) {
        this.robotName = robotName;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getNbrCle() {
        return nbrCle;
    }

    public void setNbrCle(int nbrCle) {
        this.nbrCle = nbrCle;
    }

    public String returnPossessionT() {
        if(possessionT) {
            return "T";
        } else {
            return "";
        }
    }

    public boolean getPossessionT() {
        return possessionT;
    }

    public void setPossessionT(boolean possessionT) {
        this.possessionT = possessionT;
    }


}
