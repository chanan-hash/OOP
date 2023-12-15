package Q3;

public class Balloon {
    /**
     * This class represent a 3D balloon
     * The balloon is defined by point which is the center and size if radius
     */

    // Variables
    private Point3 center;
    private double radius;

    // Constructors
    public Balloon(Point3 cen, double r) {
        this.center = new Point3(cen); // We need to creat new object
        this.radius = r;
    }

    public Balloon(Balloon b) {
        this.center = new Point3(b.center);
        this.radius = b.radius;
    }

    // getter and setters
    public Point3 getCenter() {
        return center;
    }

    public double distCenter(Balloon p) {
        return center.distance(p.getCenter());
    }

    public boolean containPont(Point3 p) { // We need to check if the dist between the given point is smaller than the radius
        return (center.distance(p) <= this.radius);
    }


    // We are checking the distance between the point and the addition of the 2 radius,
    // and according to that we know if they're intersecting, and if they do, how many times
    public int intersection(Balloon b) {// returns the number of common points of two balloons: 0, 1, 2
        double dist = center.distance(b.center);
        if (dist == 0 && this.radius == b.radius) {
            // Spheres coincide, return 2 (all points are common)
            return 3; // 2 ?
        } else if (dist <= this.radius + b.radius && dist >= Math.abs(this.radius - b.radius)) {
            // Spheres intersect at two points
            return 2;
        } else if (dist == Math.abs(this.radius - b.radius) || dist == this.radius + b.radius) {
            // Spheres touch at one point
            return 1;
        } else {
            // Spheres do not intersect
            return 0;
        }
    }

    public void setCenter(Point3 center) {
        this.center = new Point3(center);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Balloon{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    public static void main(String[] args) {
// create points
        Point3 c1 = new Point3(0, 0, 0);
        Point3 c2 = new Point3(1, 0, 0);
        Point3 c3 = new Point3(0, 2, 0);
// create balloons
        Balloon b1 = new Balloon(c1, 1);
        Balloon b2 = new Balloon(c2, 1);
        Balloon b3 = new Balloon(c3, 1);
//
        System.out.println("dist from Center: " + b1.distCenter(b2));
        System.out.println("b1 contains (0,0): " + b1.containPont(c1));
        System.out.println("b2 contains (0,0): " + b2.containPont(c1));
        System.out.println("b3 contains (0,0): " + b3.containPont(c1));
///
        System.out.println("b1 - b2: " + b1.intersection(b2));
        System.out.println("b1 - b3: " + b1.intersection(b3));
        System.out.println("b3 - b2: " + b3.intersection(b2));
    }
}
