package Q6;

import java.awt.*;
//import java.awt.geom.Point2D;
//import Q1.Point;

/**
 * A practice from the drive on static and final variables
 * https://drive.google.com/drive/folders/1XtcKLFhY3wKH4HugXbGkyCPFs37hg0rg
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

    /**
     * This is not a static function, because it depends on creating an instance of the class
     *
     * @param c
     * @return The distance between 'this' and a given circle
     */
    public double dist1(Circle c) {
        return this.center.distance(c.center);
    }

    /**
     * This is a static function, because it is not depending on creating an instance of the class
     *
     * @param c1
     * @param c2
     * @return dist --> the distance between both centers
     */
    public static double dist2(Circle c1, Circle c2) {
        return c1.center.distance(c2.center);
    }

    // Based on geeksforgeeks. This is a static function from the same reason above
    // https://www.geeksforgeeks.org/area-of-intersection-of-two-circles/
    public static double intersectionArea(Circle c1, Circle c2) {
        double area = 0;
        double dist, alpha, beta, a1, a2;
        dist = c1.center.distance(c2.center);
        if (dist > c1.radius + c2.radius) { // means the two circles are to far from each other
            return 0;
        } else if (dist <= (c1.radius - c2.radius) && c1.radius >= c2.radius) {
            area = (PI * c2.radius * c2.radius); // PI radius^2
        } else if (dist <= (c2.radius - c1.radius) && c2.radius >= c1.radius) {
            area = (PI * Math.pow(c1.radius, 2));
        } else {
            alpha = Math.acos((c1.radius * c1.radius + dist * dist - c2.radius * c2.radius) / (2 * c1.radius * dist)) * 2;
            beta = Math.acos((c2.radius * c2.radius + dist * dist - c1.radius * c1.radius) / (2 * c2.radius * dist)) * 2;
            a1 = 0.5 * beta * c2.radius * c2.radius - 0.5 * c2.radius * c2.radius * Math.sin(beta);
            a2 = 0.5 * alpha * c1.radius * c1.radius - 0.5 * c1.radius * c1.radius * Math.sin(alpha);
            area = (a1 + a2);
        }
        return area;
    }

    static final Circle canonical = new Circle(new Point(0, 0), 1); // The canonical circle is on the origin axis, and has radius 1

    /**
     * This function returns the biggest area of a Array of circles
     *
     * @param crr
     * @return
     */
    public static Circle biggestArea(Circle[] crr) {
        if (crr.length == 0) {
            throw new ArrayIndexOutOfBoundsException("The array is empty");
        }
        Circle ans = crr[0]; // Just to start with someone
        for (int i = 0; i < crr.length; i++) {
            if (crr[i].area() > ans.area()) {
                ans = crr[i]; // to be the pointer to that place
            }
        }
        return new Circle(ans); // Creating a new object that it won;t be on the same place in the memory
    }
}
