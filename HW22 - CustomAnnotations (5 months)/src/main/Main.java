package main;

import static main.ObjectTuCustomStringConverter.convert;

public class Main {
    public static void main(String[] args) throws Exception, CustomStringSerializationException {
        Circle circle = new Circle(12);
        Rectangle rectangle = new Rectangle(10,8);
        Triangle triangle = new Triangle(4, 2, 3);
        System.out.println(convert(circle));
        System.out.println(convert(rectangle));
        System.out.println(convert(triangle));
    }

}