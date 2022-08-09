package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FillTriangles extends Thread{
    public void fillTriangles() {
        try (FileWriter fileWriter = new FileWriter("Triangles_in.dat")) {
            Random random = new Random();
            for (int i = 0; i < 70000; i++) {
                fileWriter.write(random.nextInt(100) + "-" + random.nextInt(100) + "-" + random.nextInt(100) + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        fillTriangles();
    }
}
