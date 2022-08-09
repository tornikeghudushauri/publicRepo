package main;

import figures.Circle;
import figures.Rectangle;
import figures.Triangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //task1
        Runnable filler1 = new FillCircle();
        Runnable filler2 = new FillRectangles();
        Runnable filler3 = new FillTriangles();

        ExecutorService pool = Executors.newFixedThreadPool(3);

        pool.submit(filler1);
        pool.submit(filler2);
        pool.submit(filler3);

        //task2
        ReadCircles readerCircle = new ReadCircles();
        ReadRectangles readerRectangle = new ReadRectangles();
        ReadTriangles readerTriangle = new ReadTriangles();

        Future<ArrayList<Circle>> futureCircleList = pool.submit(readerCircle);
        Future<ArrayList<Rectangle>> futureRectangleList = pool.submit(readerRectangle);
        Future<ArrayList<Triangle>> futureTriangleList = pool.submit(readerTriangle);

        System.out.println(futureCircleList.get().stream().max(Circle::compareTo));
        System.out.println(futureRectangleList.get().stream().max(Rectangle::compareTo));
        System.out.println(futureTriangleList.get().stream().max(Triangle::compareTo));

        pool.shutdown();

        //task3
        Runnable circlesOutThread = new CircleOut();
        Runnable rectanglesOutThread = new RectangleOut();
        Runnable trianglesOutThread = new TriangleOut();
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.submit(circlesOutThread);
        executorService.submit(rectanglesOutThread);
        executorService.submit(trianglesOutThread);

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(3, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
        System.out.println("Finished");

        //task4
        Callable<figures.Rectangle> minLength = () -> {
            try {
                return readRecStatic().stream().min(Comparator.comparingDouble(figures.Rectangle::getLength)).get();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        };
        Callable<figures.Rectangle> maxLength = () -> {
            try {
                return readRecStatic().stream().max(Comparator.comparingDouble(figures.Rectangle::getLength)).get();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        };
        Callable<figures.Rectangle> minArea = () -> {
            try {
                return readRecStatic().stream().min(Comparator.comparingDouble(figures.Rectangle::getArea)).get();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        };
        Callable<figures.Rectangle> maxArea = () -> {
            try {
                return readRecStatic().stream().max(Comparator.comparingDouble(figures.Rectangle::getArea)).get();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        };
        ExecutorService executorService1 = Executors.newFixedThreadPool(4);
        System.out.println(executorService1.submit(minArea).get());
        System.out.println(executorService1.submit(maxArea).get());
        System.out.println(executorService1.submit(minLength).get());
        System.out.println(executorService1.submit(maxLength).get());
        executorService1.shutdown();

        //task5
        ScheduledExecutorService scheduler
                = Executors.newSingleThreadScheduledExecutor();
        Runnable tri = () -> {
            try {
                System.out.println(readTriStatic().stream()
                        .max(Comparator.comparingDouble(figures.Triangle::getLength)).get());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        };
        scheduler.schedule(tri, 5, TimeUnit.SECONDS);
        scheduler.shutdown();

        //task6
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        Runnable runnable = () -> {
            List<figures.Circle> circleList = new ArrayList<>();
            try (Scanner s = new Scanner(new File("Circles_in.dat"))) {
                String[] sideSizes;
                while (circleList.size() < 500) {
                    sideSizes = s.next().split("-");
                    if (sideSizes.length == 1) {
                        try {
                            circleList.add(new figures.Circle(Double.parseDouble(sideSizes[0])));
                            System.out.println(new figures.Circle(Double.parseDouble(sideSizes[0])));
                            if (circleList.size() == 150 || circleList.size() == 300||circleList.size()==450) {
                                Thread.currentThread().sleep(2000);
                            }
                        } catch (NumberFormatException e) {
                            continue;
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        continue;
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        };
        scheduledExecutorService.scheduleAtFixedRate(runnable, 0,2, TimeUnit.SECONDS);
        scheduledExecutorService.awaitTermination(1,TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();




        //task7
        ScheduledExecutorService scheduledExecutorService2 = Executors.newSingleThreadScheduledExecutor();
        Runnable runnable2 = () -> {
            List<figures.Circle> circleList = new ArrayList<>();
            try (Scanner s = new Scanner(new File("Circles_in.dat"))) {
                String[] sideSizes;
                while (circleList.size() < 700) {
                    sideSizes = s.next().split("-");
                    if (sideSizes.length == 1) {
                        try {
                            circleList.add(new figures.Circle(Double.parseDouble(sideSizes[0])));
                            System.out.println(new figures.Circle(Double.parseDouble(sideSizes[0])));
                            if (circleList.size() == 250 || circleList.size() == 500) {
                                Thread.currentThread().sleep(3000);
                            }
                        } catch (NumberFormatException e) {
                            continue;
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        continue;
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        };
       scheduledExecutorService2.scheduleWithFixedDelay(runnable2, 0,3, TimeUnit.SECONDS);
       scheduledExecutorService2.awaitTermination(1,TimeUnit.SECONDS);
       scheduledExecutorService2.shutdown();

    }


    public static List<Rectangle> readRecStatic() throws FileNotFoundException {
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

    public static List<Triangle> readTriStatic() throws FileNotFoundException {
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