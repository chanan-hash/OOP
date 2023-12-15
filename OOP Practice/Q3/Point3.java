package Q3;

/**
 * This class represent a 3D Point
 * This is taken from self practice:
 * https://drive.google.com/drive/folders/1rI7xavrdx89b2Kwzzrx4BYwZOysjgNwy
 */
public class Point3 {

    // Variables
    private double _x;
    private double _y;
    private double _z;


    // Constructors
    public Point3(double x, double y, double z) {
        this._x = x;
        this._y = y;
        this._z = z;
    }
    // Copy constructor

    public Point3(Point3 p3) {
        this._x = p3._x;
        this._y = p3._y;
        this._z = p3._z;
    }


    public double distance(Point3 p) {
        double res = 0;
        res = Math.sqrt(Math.pow(this._x - p._x, 2) + Math.pow(this._y - p._y, 2) + Math.pow(this._z - p._z, 2));
        return res;
    }

    public boolean equals(Point3 p) {
        return (this._x == p._x) && (this._y == p._y) && (this._z == p._z);
    }

    @Override
    public String toString() {
        return "Point3{" +
                "_x=" + _x +
                ", _y=" + _y +
                ", _z=" + _z +
                '}';
    }
}
