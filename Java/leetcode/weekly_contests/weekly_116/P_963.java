package leetcode.weekly_contests.weekly_116;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_963 {

    public double minAreaFreeRect(int[][] points) {
        double min = Double.MAX_VALUE;
        final int n = points.length;
        final Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            map.computeIfAbsent(point[0], v -> new HashSet<>()).add(point[1]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                final int dx1 = points[j][0] - points[i][0];
                final int dy1 = points[j][1] - points[i][1];
                for (int k = j + 1; k < n; k++) {
                    final int dx2 = points[k][0] - points[i][0];
                    final int dy2 = points[k][1] - points[i][1];
                    if (dx1 * dx2 + dy1 * dy2 == 0) {
                        final int x = dx1 + points[k][0];
                        final int y = dy1 + points[k][1];
                        if (map.getOrDefault(x, Collections.emptySet()).contains(y)) {
                            final double area = Math.sqrt(dx1 * dx1 + dy1 * dy1) *
                                                Math.sqrt(dx2 * dx2 + dy2 * dy2);
                            min = Math.min(min, area);
                        }
                    }
                }
            }
        }

        return Double.compare(min, Double.MAX_VALUE) == 0 ? 0.0 : min;
    }
}
