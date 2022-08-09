package main;

import figures.Rectangle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RectangleOut implements Runnable{
    public void rectanglesOut(){
        List<Rectangle> rectangleList = new ArrayList<>();
        try (Scanner s = new Scanner(new File("Rectangles_in.dat")); FileWriter writer = new FileWriter("Rectangles_out.dat")) {
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
    @Override
    public void run() {
        rectanglesOut();
    }
}
