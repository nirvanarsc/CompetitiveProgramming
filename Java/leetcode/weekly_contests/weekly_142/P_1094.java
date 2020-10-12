package leetcode.weekly_contests.weekly_142;

import java.util.ArrayList;
import java.util.List;

public class P_1094 {

    private static class Point {
        int point;
        int capacity;
        boolean isStart;

        Point(int point, int capacity, boolean isStart) {
            this.point = point;
            this.capacity = capacity;
            this.isStart = isStart;
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        final List<Point> points = new ArrayList<>();
        for (int[] trip : trips) {
            points.add(new Point(trip[1], trip[0], true));
            points.add(new Point(trip[2], trip[0], false));
        }
        points.sort((a, b) -> a.point == b.point ? Boolean.compare(a.isStart, b.isStart)
                                                 : Integer.compare(a.point, b.point));
        int currCap = capacity;
        for (Point p : points) {
            if (p.isStart) {
                if (currCap < p.capacity) {
                    return false;
                }
                currCap -= p.capacity;
            } else {
                currCap += p.capacity;
            }
        }
        return true;
    }
}
