package Lecture3Practice;

public class Square extends GeometricShape{
    private double _x1, _y1,_x2, _y2; // The Square is defined by 2 points

    public Square(double x1, double y1, double x2,double y2) {
        this._x1 = x1;
        this._y1 = y1;
        this._x2 = x2;
        this._y2 = y2;
    }
    private double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
    }
    @Override
    public double getArea() {
        double side = distance(_x1, _y1, _x2, _y2);
        return Math.pow(side,2); // because this is a square
    }

    @Override
    public double getPerimeter() {
        double side = distance(_x1, _y1, _x2, _y2);
        return 4 * side;
    }

    @Override
    public String getName() {
        return "Square";
    }

    public double get_x1() {
        return _x1;
    }

    public void set_x1(double _x1) {
        this._x1 = _x1;
    }

    public double get_x2() {
        return _x2;
    }

    public void set_x2(double _x2) {
        this._x2 = _x2;
    }
    @Override
    public String toString() {
        return "Square with area " + getArea() + " and perimeter " + getPerimeter();
    }
}
