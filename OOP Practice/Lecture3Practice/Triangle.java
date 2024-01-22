package Lecture3Practice;

public class Triangle extends GeometricShape{

    private double _x1, y1, _x2, _y2, _x3, _y3; // The triangle has 3 points

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this._x1 = x1;
        this.y1 = y1;
        this._x2 = x2;
        this._y2 = y2;
        this._x3 = x3;
        this._y3 = y3;
    }

    public double get_x1() {
        return _x1;
    }

    public void set_x1(double _x1) {
        this._x1 = _x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double get_x2() {
        return _x2;
    }

    public void set_x2(double _x2) {
        this._x2 = _x2;
    }

    public double get_y2() {
        return _y2;
    }

    public void set_y2(double _y2) {
        this._y2 = _y2;
    }

    public double get_x3() {
        return _x3;
    }

    public void set_x3(double _x3) {
        this._x3 = _x3;
    }

    public double get_y3() {
        return _y3;
    }

    public void set_y3(double _y3) {
        this._y3 = _y3;
    }

    @Override
    public double getArea() {
        double side1 = distance(_x1, y1, _x2, _y2);
        double side2 = distance(_x2, _y2, _x3, _y3);
        double side3 = distance(_x3, _y3, _x1, y1);
        double d = getPerimeter()/2;
        return  Math.sqrt(d* (d - side1) * (d - side2) * (d - side3));
    }

    @Override
    public double getPerimeter() {
        return distance(_x1, y1, _x2, _y2) + distance(_x2, _y2, _x3, _y3) + distance(_x3, _y3, _x1, y1);
    }

    /**
     * This is a private method that calculates the distance between two points
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return distance between two points
     */
    private double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
    }

    @Override
    public String getName() {
        return "Triangle";
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "_x1=" + _x1 +
                ", y1=" + y1 +
                ", _x2=" + _x2 +
                ", _y2=" + _y2 +
                ", _x3=" + _x3 +
                ", _y3=" + _y3 +
                '}';
    }
}
