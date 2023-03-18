package leetcode.biweekly_contests.biweekly_0_99.biweekly_76;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P_4 {

    public int maximumScore(int[] scores, int[][] edges) {
        final Map<Integer, PriorityQueue<int[]>> map = new HashMap<>();
        for (int[] edge : edges) {
            final int u = edge[0];
            final int v = edge[1];
            map.computeIfAbsent(u, val -> new PriorityQueue<>(Comparator.comparingInt(a -> a[1])))
               .add(new int[] { v, scores[v] });
            map.computeIfAbsent(v, val -> new PriorityQueue<>(Comparator.comparingInt(a -> a[1])))
               .add(new int[] { u, scores[u] });
            final PriorityQueue<int[]> l = map.get(u);
            final PriorityQueue<int[]> r = map.get(v);
            if (l.size() > 3) {
                l.remove();
            }
            if (r.size() > 3) {
                r.remove();
            }
        }
        int res = -1;
        for (int[] edge : edges) {
            final int u = edge[0];
            final int v = edge[1];
            final PriorityQueue<int[]> l = map.get(u);
            final PriorityQueue<int[]> r = map.get(v);
            for (int[] uu : l) {
                for (int[] vv : r) {
                    if (uu[0] != vv[0] && uu[0] != u && uu[0] != v && vv[0] != u && vv[0] != v) {
                        res = Math.max(res, scores[u] + scores[v] + uu[1] + vv[1]);
                    }
                }
            }
        }
        return res;
    }
}
