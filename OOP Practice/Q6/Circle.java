package Q6;

import java.awt.*;
//import java.awt.geom.Point2D;
//import Q1.Point;

/**
 * A practice from the drive on static and final variables
 */
public class Circle {
    static final double PI = 3.141592; // Constant value. Final valuesAre written with capital letters

    // variables
//    private Point2D center;
    private Point center;
    private double radius;

    // Constructors
    public Circle(Point p, double r) {
        this.center = new Point(p);
        this.radius = r;
    }

    // Copy constructor
    public Circle(Circle c) {
        this.center = new Point(c.center);
        this.radius = c.radius;
    }

    // The formula is PI*R^2
    public double area() {
        return (PI * Math.pow(this.radius, 2));
    }

    public double perimeter() {
        return (2 * PI * this.radius);
    }
}
