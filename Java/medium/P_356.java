package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class P_356 {

    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        final Set<String> set = new HashSet<>();
        for (int[] p : points) {
            max = Math.max(max, p[0]);
            min = Math.min(min, p[0]);
            set.add(p[0] + "," + p[1]);
        }
        final int sum = max + min;
        for (int[] p : points) {
            if (!set.contains((sum - p[0]) + "," + p[1])) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("ConstantConditions")
    public boolean isReflectedBST(int[][] points) {
        final Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            map.computeIfAbsent(p[1], v -> new TreeSet<>()).add(p[0]);
        }
        Double d = null;
        for (TreeSet<Integer> val : map.values()) {
            while (val.size() > 1) {
                final int lo = val.pollFirst();
                final int hi = val.pollLast();
                if (d == null) {
                    d = (lo + hi) * 0.5;
                } else {
                    if (Double.compare(d, (lo + hi) * 0.5) != 0) {
                        return false;
                    }
                }
            }
            if (val.size() == 1) {
                if (d == null) {
                    d = (double) val.first();
                } else {
                    if (Double.compare(d, (double) val.first()) != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
