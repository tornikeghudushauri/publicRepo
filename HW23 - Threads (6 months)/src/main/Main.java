package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread dzimon = new DaemonThread();
        dzimon.setDaemon(true);
        dzimon.start();

        FillCircle fill1 = new FillCircle();
        FillRectangles fill2 = new FillRectangles();
        FillTriangles fill3 = new FillTriangles();

        fill1.start();
        fill2.start();
        fill3.start();

        fill1.join();
        fill2.join();
        fill3.join();

        Thread read1 = new Thread(() -> readCircle("Circles_in.dat"));
        Thread read2 = new Thread(() -> readTriangle("Triangles_in.dat"));
        Thread read3 = new Thread(() -> readRectangle("Rectangles_in.dat"));

        read1.start();
        read2.start();
        read3.start();


    }


    public static void readCircle(String inputFile) {
        List<Circle> circleList = new ArrayList<>();
        try (Scanner s = new Scanner(new File(inputFile)); FileWriter writer = new FileWriter("Circles_out.dat");) {
            String[] sideSizes;
            while (s.hasNext()) {
                sideSizes = s.next().split("-");
                if (sideSizes.length == 1) {
                    try {
                        circleList.add(new Circle(Double.parseDouble(sideSizes[0])));
                    } catch (NumberFormatException e) {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            for (Circle c : circleList) {
                writer.write((int) c.getRadius() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readTriangle(String inputFile) {
        List<Triangle> triangleList = new ArrayList<>();
        try (Scanner s = new Scanner(new File(inputFile)); FileWriter writer = new FileWriter("Triangles_out.dat")) {
            String[] sideSizes;
            while (s.hasNext()) {
                sideSizes = s.next().split("-");
                if (sideSizes.length == 3) {
                    try {
                        triangleList.add(new Triangle(Double.parseDouble(sideSizes[0]), Double.parseDouble(sideSizes[1]), Double.parseDouble(sideSizes[2])));
                    } catch (NumberFormatException e) {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            for (Triangle t : triangleList) {
                writer.write((int) t.getA() + "#" + (int) t.getB() + "#" + (int) t.getC() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readRectangle(String inputFile) {
        List<Rectangle> rectangleList = new ArrayList<>();
        try (Scanner s = new Scanner(new File(inputFile)); FileWriter writer = new FileWriter("Rectangles_out.dat")) {
            String[] sideSizes;
            while (s.hasNext()) {
                sideSizes = s.next().split("-");
                if (sideSizes.length == 2) {
                    try {
                        rectangleList.add(new Rectangle(Double.parseDouble(sideSizes[0]), Double.parseDouble(sideSizes[1])));
                    } catch (NumberFormatException e) {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            for (Rectangle r : rectangleList) {
                writer.write((int) r.getHeight() + "#" + (int) r.getWidth() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}