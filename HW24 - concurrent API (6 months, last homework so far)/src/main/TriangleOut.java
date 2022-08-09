package main;

import figures.Triangle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TriangleOut implements Runnable{
    public void trianglesOut(){
        List<Triangle> triangleList = new ArrayList<>();
        try (Scanner s = new Scanner(new File("Triangles_in.dat")); FileWriter writer = new FileWriter("Triangles_out.dat")) {
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
    @Override
    public void run() {
trianglesOut();
    }
}
