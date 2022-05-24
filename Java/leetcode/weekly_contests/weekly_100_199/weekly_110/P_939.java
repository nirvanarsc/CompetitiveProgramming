package leetcode.weekly_contests.weekly_100_199.weekly_110;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_939 {

    public int minAreaRect(int[][] points) {
        int min = Integer.MAX_VALUE;
        final Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            map.computeIfAbsent(point[0], v -> new HashSet<>()).add(point[1]);
        }

        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] != p2[0] && p1[1] != p2[1]) {
                    if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                        min = Math.min(min, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                    }
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
