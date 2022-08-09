package main;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Random;

public class FillRectangles implements Runnable {
    public void fillRectangles() {
        try (FileWriter fileWriter = new FileWriter("Rectangles_in.dat")) {
            Random random = new Random();
            for (int i = 0; i < 30000; i++) {
                fileWriter.write(random.nextInt(100) + "-" + random.nextInt(100) + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        fillRectangles();
        System.out.println(LocalTime.now());
    }
}
