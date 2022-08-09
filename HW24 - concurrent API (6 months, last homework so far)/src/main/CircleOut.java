package main;

import figures.Circle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CircleOut implements Runnable{
    public void circlesOut(){
        List<Circle> circleList = new ArrayList<>();
        try (Scanner s = new Scanner(new File("Circles_in.dat")); FileWriter writer = new FileWriter("Circles_out.dat");) {
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
    @Override
    public void run() {
        circlesOut();
    }
}
