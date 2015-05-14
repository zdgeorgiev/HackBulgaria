package pointCalcs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

    public static void main(String[] args) {
        final List<Point> points = PointUtils.generatePoints();

        float start = System.currentTimeMillis();

        Map<Point, Point> nearestPoints = new HashMap<Point, Point>();
        nearestPoints = PointUtils.getNearestPoints(points);

        System.out.println("Size - " + nearestPoints.size());
        System.out.println((System.currentTimeMillis() - start) / 1000);
    }
}
