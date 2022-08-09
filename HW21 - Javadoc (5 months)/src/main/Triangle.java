package main;

/**
 * <h1>Create Triangles!</h1>
 * The Triangle class
 * implements all the Figure class methods
 * and has some of it's own.
 * <p>
 * <b>Note:</b> While creating Triangle instances
 * do not forget that it takes type doubles as
 * a, b and c.
 *
 * @author Tornike Ghudushauri
 * @version 21.0
 * @since 1.0
 */
@SuppressWarnings({"unused", "FieldMayBeFinal"})
public class Triangle extends Figure implements Comparable<Triangle> {
    /**
     * @param f Parameter must be an instance of Figure class.
     * @since 20.0
     * @deprecated reason is simple, but yet unknown. <br/>
     * {will be removed in next version} <br/>
     * use {@link #getLength()} instead like this:
     * <blockquote><pre>
     * Triangle.getLength()
     * </pre></blockquote>
     */
    @Deprecated
    public static double getLengthStatic(Figure f) {
        Triangle t = (Triangle) f;
        return t.a + t.b + t.c;
    }

    private double a;
    private double b;
    private double c;

    /**
     * Constructor of a Triangle class.
     * @param a Must be a double type.
     * @param b Must be a double type.
     * @param c Must be a double type.
     */
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Returns h of a triangle calculated with math formula.
     *
     * @return h of a triangle as a double.
     */
    public double getH() {
        return (2 * getArea()) / a;
    }

    /**
     * Getter of a field.
     */
    public double getA() {
        return a;
    }

    /**
     * Getter of b field.
     */
    public double getB() {
        return b;
    }

    /**
     * Getter of c field.
     */
    public double getC() {
        return c;
    }

    /**
     * Returns actual length of the triangle.
     * Has no parameters.
     *
     * @return Length of triangle calculated with math formula.
     * @since 1.0
     */
    @Override
    public double getLength() {
        return a + b + c;
    }

    /**
     * Returns actual area of the triangle.
     * Has no parameters.
     *
     * @return Area of triangle calculated with math formula.
     * @since 1.0
     */
    @Override
    public double getArea() {
        double area, resArea;
        area = (a + b + c) / 2.0d;
        resArea = Math.sqrt(area * (area - a) * (area - b) * (area - c));
        return resArea;
    }

    /**
     * Returns 0 if Triangle is equal the other Triangle.
     * Positive if First Triangle is bigger.
     * Negative if First Triangle is smaller.
     * o must be Triangle to give proper comparison.
     *
     * @param o a Triangle given to see if it is equal or not.
     * @return specified int type.
     * @since 1.0
     */
    @Override
    public int compareTo(Triangle o) {
        return Double.compare(this.getLength(), o.getLength());
    }

    /**
     * Returns Triangle object as a String with values of its sides.
     * Has no parameters.
     *
     * @return Triangle as a String.
     * @since 1.0
     */
    @Override
    public String toString() {
        return "Triangle [a=" + a + ", b=" + b + ", c=" + c + "]";
    }

    /**
     * Returns True if Triangle is Right Angled and False otherwise.
     *
     * @param t is an object of Triangle class.
     * @return Specified boolean.
     * @since 1.0
     */
    public boolean isRightTriangle(Triangle t) {
        return t.c == Math.sqrt((t.a * t.a) + (t.b * t.b));
    }


}
