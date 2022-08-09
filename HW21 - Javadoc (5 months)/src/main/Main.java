package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({"deprecation", "rawtypes", "unused", "ResultOfMethodCallIgnored", "UnnecessaryContinue", "unchecked", "CommentedOutCode"})
public class Main {

    public static void main(String[] args) {
        // Task 5
        Circle circle1 = new Circle(1);
        main.Circle.getLengthStatic(circle1);
        ArrayList rectangleList = new ArrayList();
        readRectangle(rectangleList, "Rectangles_in.dat");

        List<Figure> figures = new ArrayList<>();
        figures.add(circle1);

        buggedMethod(figures);
        System.out.println(figures);

        //Task 8
        Merve length = (a, b) -> a.getLength() + b.getLength();
        System.out.println("perimetrit: " + length.plus(circle1, circle1));

        Merve area = (a, b) -> a.getArea() + b.getArea();
        System.out.println("fartobit: " + area.plus(circle1, circle1));
    }

    @FunctionalInterface
    interface Merve {
        double plus(Figure a, Figure b);
    }
    // Task 5

    /**
     * Reads and adds Rectangles from the file to the arraylist.
     *
     * @param rectangleList the arraylist
     * @param inputFile     the file
     * @since 21.0
     */
    public static void readRectangle(ArrayList rectangleList, String inputFile) {
        try (Scanner s = new Scanner(new File(inputFile))) {
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Task 6
//    public static void buggedMethod(List<Figure>... lists) {
//        int length = lists.length;
//        for (List<Figure> f :
//                lists) {
//           Triangle triangle = (Triangle) f.get(0);
//        }
//    }

    // Task 7
    public static void buggedMethod(List<Figure>... lists) {
        int length = lists.length;
        for (List<Figure> f :
                lists) {
            try {
                Triangle triangle = (Triangle) f.get(0);
            } catch (ClassCastException e) {
                continue;
            }
        }
    }


}