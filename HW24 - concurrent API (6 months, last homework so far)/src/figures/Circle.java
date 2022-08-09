package figures;

@SuppressWarnings("unused")
public class Circle extends Figure implements Comparable<Circle> {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }


    @Override
    public String toString() {
        return "figures.Circle [radius=" + radius + "]";
    }


    @Override
    public double getLength() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Circle other = (Circle) obj;
        return Double.doubleToLongBits(radius) == Double.doubleToLongBits(other.radius);
    }


    @Override
    public int compareTo(Circle o) {
        return Double.compare(this.getLength(), o.getLength());
    }

    public boolean isValid() {
        return radius > 0;
    }
}
