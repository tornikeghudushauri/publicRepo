package main;

/**
 * <h1>Create Rectangles!</h1>
 * The Rectangle class
 * implements all the Figure class methods
 * and has some of it's own.
 * <p>
 * <b>Note:</b> While creating Rectangle instances
 * do not forget that it takes type doubles as a
 * height and a length.
 *
 * @author Tornike Ghudushauri
 * @version 21.0
 * @since 1.0
 */
@SuppressWarnings("unused")
public class Rectangle extends Figure implements Comparable<Rectangle> {
    /**
     * @param f Parameter must be an instance of Figure class.
     * @since 20.0
     * @deprecated reason is simple, but yet unknown. <br/>
     * {will be removed in next version} <br/>
     * use {@link #getLength()} instead like this:
     * <blockquote><pre>
     * Rectangle.getLength()
     * </pre></blockquote>
     */
    @Deprecated
    public static double getLengthStatic(Figure f) {
        Rectangle r = (Rectangle) f;
        return 2 * (r.height + r.width);
    }

    double height;
    double width;

    /**
     * Constructor of a Rectangle class.
     * @param height Must be double type.
     * @param width Mustb be double type.
     */
    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    /**
     * Getter of height field.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Getter of width field.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Returns Rectangle object as a String with values of it's sides.
     * Has no parameters.
     *
     * @return Rectangle as a String.
     * @since 1.0
     */
    @Override
    public String toString() {
        return "Rectangle [height=" + height + ", width=" + width + "]";
    }

    /**
     * Returns Rectangles diagonal as a double type value.
     *
     * @return double diagonal.
     * @since 1.0
     */
    public double getDiagonal() {
        return Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2));
    }

    /**
     * Returns actual length of the rectangle.
     * Has no parameters.
     *
     * @return Length of rectangle calculated with math formula.
     * @since 1.0
     */
    @Override
    public double getLength() {
        return 2 * (height + width);
    }

    /**
     * Returns actual area of the rectangle.
     * Has no parameters.
     *
     * @return Area of rectangle calculated with math formula.
     * @since 1.0
     */
    @Override
    public double getArea() {
        return height * width;
    }

    /**
     * Returns 0 if Rectangle is equal the other Rectangle.
     * Positive if First Rectangle is bigger.
     * Negative if First Rectangle is smaller.
     * o must be Rectangle to give proper comparison.
     *
     * @param o a Rectangle given to see if it is equal or not.
     * @return specified int type.
     * @since 1.0
     */
    @Override
    public int compareTo(Rectangle o) {
        return Double.compare(this.getLength(), o.getLength());
    }


}
