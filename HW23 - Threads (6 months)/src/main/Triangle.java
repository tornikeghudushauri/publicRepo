package main;

public class Triangle extends Figure implements Comparable<Triangle> {
    private double a;

   private double b;

    private double c;


    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getH() {
        return (2 * getArea()) / a;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public double getLength() {
        return a + b + c;
    }

    @Override
    public double getArea() {
        double area, resArea;
        area = (a + b + c) / 2.0d;
        resArea = Math.sqrt(area * (area - a) * (area - b) * (area - c));
        return resArea;
    }

    @Override
    public int compareTo(Triangle o) {
        return Double.compare(this.getLength(), o.getLength());
    }

    @Override
    public String toString() {
        return "Triangle [a=" + a + ", b=" + b + ", c=" + c + "]";
    }

    public boolean isRightTriangle(Triangle t) {
        boolean result;
        result = t.c == Math.sqrt((t.a * t.a) + (t.b * t.b));
        return result;
    }

    public boolean isValid() {
        return !(a + b <= c) && !(a + c <= b) && !(b + c <= a);
    }

}
