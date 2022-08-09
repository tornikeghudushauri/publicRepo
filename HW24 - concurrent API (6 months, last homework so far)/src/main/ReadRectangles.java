package main;

import figures.Rectangle;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class ReadRectangles implements Callable {
    @Override
    public Object call() throws Exception {
        List<Rectangle> rectangleList = new ArrayList<>();
        try (Scanner s = new Scanner(new File("Rectangles_in.dat"))) {
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

            return rectangleList;
        }
    }
}
