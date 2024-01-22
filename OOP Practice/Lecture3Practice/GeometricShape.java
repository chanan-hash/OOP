package Lecture3Practice;

/**
 * Abstract class for geometric shapes.
 */
public abstract class GeometricShape {

/**
     * Returns the area of the shape.
     * @return the area of the shape
     */
    public abstract double getArea();

    /**
     * Returns the perimeter of the shape.
     * @return the perimeter of the shape
     */
    public abstract double getPerimeter();

    /**
     * Returns the name of the shape.
     * @return the name of the shape
     */
    public abstract String getName();

    /**
     * Returns a string representation of the shape.
     * @return a string representation of the shape
     */
    @Override
    public String toString() {
        return getName() + " with area " + getArea() + " and perimeter " + getPerimeter();
    }
}
