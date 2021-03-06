package pointCalcs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        final List<Point> points = PointUtils.generatePoints();
        System.out.println((System.currentTimeMillis() - start) / 1000);

        start = System.currentTimeMillis();
        Map<Point, Point> nearestPoints = new HashMap<Point, Point>();
        nearestPoints = PointUtils.getNearestPoints(points);

        System.out.println((System.currentTimeMillis() - start) / 1000);
    }
}
