
import java.awt.Point;

public class Ball {

    // Variable
    private Point p;

    // Constructor
    public Ball(Point p) {
        this.p = new Point(p);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "p=" + p.toString() +
                '}';
    }

    public void moveLeft(int vector) {
        this.p.x -= vector;
    }

    // we can use inbuilt function of Point class for this or to add by ourselves
    public void moveRight(int vector) {
        this.p.translate(vector, 0);
    }

    public void moveForward(int dist) {
        this.p.y += dist;
    }

    // Using inbuilt 'move' function, that just changes the 'x' and 'y' coordinates, so not to loos them we are adding or keeping them
    public void moveBack(int dist) {
        this.p.move(this.p.x, this.p.y - dist);
    }

    public Point getP() {
        return this.p;
    }
}
