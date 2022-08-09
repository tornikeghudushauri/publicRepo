package main;

import annotations.SkipSerialization;
import annotations.Validator;

@SuppressWarnings("unused")
public class Rectangle extends Figure implements Comparable<Rectangle> {
    @Validator
    double height;
    @Validator
    double width;
    @SkipSerialization
    String name = "marta";

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "Rectangle [height=" + height + ", width=" + width + "]";
    }

    public double getDiagonal() {
        return Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2));
    }

    @Override
    public double getLength() {
        return 2 * (height + width);
    }

    @Override
    public double getArea() {
        return height * width;
    }


    @Override
    public int compareTo(Rectangle o) {
        return Double.compare(this.getLength(), o.getLength());
    }

    @Validator
    public boolean isValid() {
        return height > 0 && width > 0;
    }

}
