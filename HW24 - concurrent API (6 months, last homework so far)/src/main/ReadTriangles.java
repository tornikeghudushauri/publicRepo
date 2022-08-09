package main;

import figures.Triangle;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class ReadTriangles implements Callable {
    @Override
    public Object call() throws Exception {
        List<Triangle> triangleList = new ArrayList<>();
        try (Scanner s = new Scanner(new File("Triangles_in.dat"))) {
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

            return triangleList;
        }
    }
}
