package main;

/**
 * <h1>Create Circles!</h1>
 * The Circle class
 * implements all the Figure class methods
 * and has some of it's own.
 * <p>
 * <b>Note:</b> While creating circle instances
 * do not forget that it takes type double as a radius.
 *
 * @author Tornike Ghudushauri
 * @version 21.0
 * @since 1.0
 */
@SuppressWarnings("ALL")
public class Circle extends Figure implements Comparable<Circle> {
    private double radius;

    /**
     * Construcor of a Circle class.
     * @param radius Must be double type.
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * @param f Parameter must be an instance of Figure class.
     * @since 20.0
     * @deprecated reason is simple, but yet unknown. <br/>
     * {will be removed in next version} <br/>
     * use {@link #getLength()} instead like this:
     * <blockquote><pre>
     * Circle.getLength()
     * </pre></blockquote>
     */
    @Deprecated
    public static double getLengthStatic(Figure f) {
        Circle c = (Circle) f;
        return 2 * Math.PI * c.radius;
    }

    /**
     * Getter of a radius field.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Returns Circle object as a String with value of it's radius.
     * Has no parameters.
     *
     * @return Circle as a String.
     * @since 1.0
     */
    @Override
    public String toString() {
        return "Circle [radius=" + radius + "]";
    }

    /**
     * Returns actual length of the circle.
     * Has no parameters.
     *
     * @return Length of circle calculated with math formula.
     * @since 1.0
     */
    @Override
    public double getLength() {
        return 2 * Math.PI * radius;
    }

    /**
     * Returns actual area of the circle.
     * Has no parameters.
     *
     * @return Area of circle calculated with math formula.
     * @since 1.0
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Returns true if Circle is equal the other Circle.
     * obj must be Circle to give proper comparison.
     *
     * @param obj a Circle given to see if it is equal or not.
     * @return specified boolean type.
     * @since 1.0
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Circle other = (Circle) obj;
        return Double.doubleToLongBits(radius) == Double.doubleToLongBits(other.radius);
    }

    /**
     * Returns 0 if Circle is equal the other Circle.
     * Positive if First Circle is bigger.
     * Negative if First Circle is smaller.
     * o must be Circle to give proper comparison.
     *
     * @param o a Circle given to see if it is equal or not.
     * @return specified int type.
     * @since 1.0
     */
    @Override
    public int compareTo(Circle o) {
        return Double.compare(this.getLength(), o.getLength());
    }
}

