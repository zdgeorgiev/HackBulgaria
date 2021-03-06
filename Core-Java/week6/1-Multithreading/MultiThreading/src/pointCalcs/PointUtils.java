package pointCalcs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class PointUtils {
    public static Map<Point, Point> getNearestPoints(final List<Point> points) {
        final Map<Point, Point> calculated = new ConcurrentHashMap<>();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("1");
                PointUtils.doCalculations(points, 0, 25_000, calculated);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("2");
                PointUtils.doCalculations(points, 25_000, 50_000, calculated);
            }
        });

        Thread t3 = new Thread(new Runnable() {
            public void run() {
                System.out.println("3");
                PointUtils.doCalculations(points, 50_000, 75_000, calculated);
            }
        });

        Thread t4 = new Thread(new Runnable() {
            public void run() {
                System.out.println("4");
                PointUtils.doCalculations(points, 75_000, 100_000, calculated);
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return calculated;
    }

    private static void doCalculations(List<Point> inPoints, int indexFrom, int indexTo, Map<Point, Point> outMap) {

        for (int i = indexFrom; i < indexTo; i++) {
            Point currentPoint = inPoints.get(i);
            Point nearestPoint = null;

            double minDistance = Double.MAX_VALUE;

            for (int j = 0; j < inPoints.size(); j++) {

                Point nextPoint = inPoints.get(j);
                double distance = currentPoint.getDistance(nextPoint);

                if (distance < minDistance) {
                    minDistance = distance;
                    nearestPoint = nextPoint;
                }
            }

            if (outMap.containsKey(currentPoint)) {
                System.out.println("WTF?");
            }

            outMap.put(currentPoint, nearestPoint);
        }
    }

    public static List<Point> generatePoints() {
        List<Point> list = new ArrayList<Point>();

        Random random = new Random();

        for (int i = 0; i < 100_000; i++) {
            int x = random.nextInt(10_001);
            int y = random.nextInt(10_001);

            while (list.contains(new Point(x, y))) {
                x = random.nextInt(10_001);
                y = random.nextInt(10_001);
            }

            list.add(new Point(x, y));
        }

        return list;
    }
}
