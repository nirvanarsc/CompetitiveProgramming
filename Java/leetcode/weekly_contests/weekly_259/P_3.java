package leetcode.weekly_contests.weekly_259;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({ "InnerClassMayBeStatic", "PublicConstructorInNonPublicClass", "unused" })
public class P_3 {

    class DetectSquares {

        Map<Integer, Map<Integer, Integer>> byX;

        public DetectSquares() {
            byX = new HashMap<>();
        }

        public void add(int[] point) {
            byX.computeIfAbsent(point[0], val -> new HashMap<>()).merge(point[1], 1, Integer::sum);
        }

        public int count(int[] point) {
            int res = 0;
            final int x = point[0];
            final int y = point[1];
            for (Map.Entry<Integer, Integer> e : byX.getOrDefault(x, new HashMap<>()).entrySet()) {
                final int y2 = e.getKey();
                final int d = Math.abs(y - y2);
                if (d > 0) {
                    final int c1 = byX.getOrDefault(x + d, new HashMap<>()).getOrDefault(y, 0);
                    final int c2 = byX.getOrDefault(x + d, new HashMap<>()).getOrDefault(y2, 0);
                    final int c3 = byX.getOrDefault(x - d, new HashMap<>()).getOrDefault(y, 0);
                    final int c4 = byX.getOrDefault(x - d, new HashMap<>()).getOrDefault(y2, 0);
                    res += e.getValue() * c1 * c2;
                    res += e.getValue() * c3 * c4;
                }
            }
            return res;
        }
    }
}
