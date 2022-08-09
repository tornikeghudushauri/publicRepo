package main;

import figures.Circle;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class ReadCircles implements Callable {
    @Override
    public Object call() throws Exception {
        List<Circle> circleList = new ArrayList<>();
        try (Scanner s = new Scanner(new File("Circles_in.dat"))) {
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

            return circleList;
        }
    }
}
