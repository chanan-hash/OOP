package Lecture3Practice;

public class Square extends GeometricShape{
    private double _x1, _x2; // Needs to points for size of square, all the sides are equal

    public Square(double x1, double y1, double x2) {
        this._x1 = x1;
        this._x2 = x2;
    }
    @Override
//    public double getArea() {
//        return Math.abs(_x2 - _x1) * Math.abs(_y2 - _y1); //
//    }
//
    public double getArea() {
        return Math.pow(_x2 - _x1,2); // because this is a square
    }

    @Override
    public double getPerimeter() {
        return 4 * Math.abs(_x2 - _x1);
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
