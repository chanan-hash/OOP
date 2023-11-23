package Q1;

public final class Point {
    private double _x, _y;
    private UID _id;

    public Point(double x1, double y1) {
        _x = x1;
        _y = y1;
        _id = new UID();
    }

    public Point() {
        _x = 0;
        _y = 0;
        _id = new UID();
    }

    @Override
    public String toString() {
        return "id: " + _id + " (" + _x + "," + _y + ")";
    }

    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point(9,9);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3);
    }
}
