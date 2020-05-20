package exe06;

public class Point {
    private final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean egal(int x, int y) {
        return x == this.x && y == this.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
