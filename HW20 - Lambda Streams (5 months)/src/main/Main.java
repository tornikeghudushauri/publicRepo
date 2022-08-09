package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SuppressWarnings("ALL")
public class Main {

    public static void main(String[] args) throws IOException {
        // Task 1
        List<Circle> circleList = new ArrayList<>();
        circleList.add(new Circle(1));
        circleList.add(new Circle(122));
        circleList.add(new Circle(13));
        circleList.add(new Circle(12));
        circleList.add(new Circle(11));
        circleList.add(new Circle(9));

        long count = pirveli(circleList);
        System.out.println(count);

        // Task 2
        List<Rectangle> rectangleList = new ArrayList<>();
        rectangleList.add(new Rectangle(10, 8));
        rectangleList.add(new Rectangle(15, 11));
        rectangleList.add(new Rectangle(14, 12));
        rectangleList.add(new Rectangle(13, 9));
        rectangleList.add(new Rectangle(16, 9));

        List<Double> rectangleHeightList = meore(rectangleList);
        System.out.println(rectangleHeightList);

        // Task 3
        List<Triangle> triangleList = new ArrayList<>();
        triangleList.add(new Triangle(3, 4, 5));
        triangleList.add(new Triangle(5, 12, 13));
        triangleList.add(new Triangle(1, 2, 2));

        mesame(triangleList);

        // Task 4
        Set<Circle> circleSet = new HashSet<>();
        circleSet.add(new Circle(1));
        circleSet.add(new Circle(2));
        circleSet.add(new Circle(3));
        circleSet.add(new Circle(4));

        meotxe(circleSet);

        // Task 5
        Set<Rectangle> rectangleSet = new HashSet<>();
        rectangleSet.add(new Rectangle(30, 40));
        rectangleSet.add(new Rectangle(30, 41));
        rectangleSet.add(new Rectangle(31, 39));
        rectangleSet.add(new Rectangle(32, 32));
        rectangleSet.add(new Rectangle(33, 40));

        Set<Rectangle> rectangleSet2 = mexute(rectangleSet);
        System.out.println(rectangleSet2);

        // Task 6
        Set<Triangle> triangleSet = new HashSet<>();
        triangleSet.add(new Triangle(2, 3, 4));
        triangleSet.add(new Triangle(3, 3, 4));
        triangleSet.add(new Triangle(12, 13, 14));
        triangleSet.add(new Triangle(10, 23, 24));

        Set<Double> triangleSet2 =meeqvse(triangleSet);
        System.out.println(triangleSet2);

        // Task 7
        List<Circle> circleList2 = new ArrayList<>();
        circleList2.add(new Circle(1));
        circleList2.add(new Circle(1));
        circleList2.add(new Circle(1));
        circleList2.add(new Circle(2));
        circleList2.add(new Circle(2));
        circleList2.add(new Circle(2));

        Map<Double, Long> groupByRadius_Count = meshvide(circleList2);
        System.out.println(groupByRadius_Count);

        // Task 8
        List<Rectangle> rectangleList2 = new ArrayList<>();
        rectangleList2.add(new Rectangle(10, 8));
        rectangleList2.add(new Rectangle(10, 10));
        rectangleList2.add(new Rectangle(10, 9));
        rectangleList2.add(new Rectangle(11, 9));
        rectangleList2.add(new Rectangle(11, 8));

        Map<Double, Double> groupByLength_minWidth = merve(rectangleList2);
        System.out.println(groupByLength_minWidth);

        // Task 9
        List<Triangle> triangleList2 = new ArrayList<>();
        triangleList2.add(new Triangle(3, 4, 5));
        triangleList2.add(new Triangle(3, 4, 5));
        triangleList2.add(new Triangle(3, 4, 5));
        triangleList2.add(new Triangle(5, 12, 13));
        triangleList2.add(new Triangle(5, 12, 13));
        triangleList2.add(new Triangle(5, 12, 13));

        Map<Double, DoubleSummaryStatistics> groupByHeight_SumarrizePerimeter =mecxre(triangleList2);
        System.out.println(groupByHeight_SumarrizePerimeter);

        // Task 10.3
        List<Integer> list = printPrimeNumbers(1, 100);
        System.out.println(list);

        // Task 11
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        // Task 12

            metormete(args[0], args[1]);

    }

    // Task 1
    public static long pirveli(List<Circle> circleList) {
        long count = circleList.stream().filter(c -> c.getRadius() > 10).count();
        return count;
    }

    // Task 2
    public static List<Double> meore(List<Rectangle> rectangleList) {
        List<Double> rectangleHeightList = rectangleList.stream().filter(r -> r.getArea() > 100)
                .map(r -> r.getHeight()).collect(Collectors.toList());
        return rectangleHeightList;
    }

    // Task 3
    public static void mesame(List<Triangle> triangleList) {
        triangleList.stream().filter(t -> t.isRightTriangle(t))
                .forEach(t -> System.out.println("მართკუთხა სამკუთხედის პერიმეტრია: "
                        + t.getLength()));

    }

    // Task 4
    public static void meotxe(Set<Circle> circleSet) {
        Circle maxArea = circleSet.stream().max(Comparator.comparing(Circle::getArea))
                .orElseThrow(NoSuchElementException::new);
        Circle minLength = circleSet.stream().min(Comparator.comparing(Circle::getLength))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("უდიდესი ფართობი: " + maxArea.getArea()
                + " უმცირესი სიგრძე: " + minLength.getLength());
    }

    // Task 5
    public static Set<Rectangle> mexute(Set<Rectangle> rectangleSet) {
        Set<Rectangle> rectangleSet2 = rectangleSet.stream().filter(r -> r.getDiagonal() > 50)
                .collect(Collectors.toSet());
        return rectangleSet2;
    }

    // Task 6
    public static Set<Double> meeqvse(Set<Triangle> triangleSet) {
        Set<Double> triangleSet2 = triangleSet.stream().filter(t -> t.getLength() <= 29.5)
                .map(t -> t.getLength()).collect(Collectors.toSet());
        return triangleSet2;
    }

    // Task 7
    public static Map<Double, Long> meshvide(List<Circle> circleList2) {
        Map<Double, Long> groupByRadius_Count = circleList2.stream()
                .collect(Collectors.groupingBy(c -> c.getRadius(), Collectors.counting()));
        return groupByRadius_Count;
    }

    // Task 8
    public static Map<Double, Double> merve(List<Rectangle> rectangleList2) {
        Map<Double, Double> groupByLength_minWidth = rectangleList2.stream()
                .collect(Collectors.groupingBy(Rectangle::getHeight, Collectors.collectingAndThen(
                        Collectors.minBy(Comparator.comparingDouble(Rectangle::getWidth)),
                        result -> result.map(Rectangle::getWidth).orElseThrow())));
        return groupByLength_minWidth;
    }

    // Task 9
    public static Map<Double, DoubleSummaryStatistics> mecxre(List<Triangle> triangleList2) {
        Map<Double, DoubleSummaryStatistics> groupByHeight_SumarrizePerimeter =
                triangleList2.stream().collect(Collectors.groupingBy(t -> t.getA(), Collectors.summarizingDouble(t -> t.getLength())));
        return groupByHeight_SumarrizePerimeter;
    }

    // Task 10.1
    public static boolean isPrime(int number) {
        return number > 1
                && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> (number % n == 0));
    }

    // Task 10.2
    public static List<Integer> printPrimeNumbers(int from, int to) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = from; i <= to; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            } else continue;
        }
        return primeNumbers;
    }

    // Task 12
    public static void metormete(String in, String out) throws IOException {
        File file = new File(in);
        if (!file.exists()) {
            throw new RuntimeException("File doesn't exist!");
        }
        Scanner scanner = new Scanner(file);
        FileWriter fw = new FileWriter(out);
        try (scanner; fw) {
            do {
                String data = scanner.nextLine().replaceAll("\\s+", "_").toUpperCase();
                fw.write(data);
                fw.append("\n");
            } while (scanner.hasNextLine());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
