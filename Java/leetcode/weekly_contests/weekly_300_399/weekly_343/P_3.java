package leetcode.weekly_contests.weekly_300_399.weekly_343;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P_3 {

    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        final Map<String, Integer> d = new HashMap<>();
        d.put(start[0] + "," + start[1], 0);
        pq.offer(new int[] { start[0], start[1], 0 });
        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            final int u = curr[0];
            final int v = curr[1];
            final int w = curr[2];
            if (d.get(u + "," + v) < w) {
                continue;
            }
            for (int[] s : specialRoads) {
                final int nu = s[2];
                final int nv = s[3];
                final int nw = Math.abs(s[0] - u) + Math.abs(s[1] - v) + s[4];
                if (d.getOrDefault(nu + "," + nv, (int) 1e9) > d.get(u + "," + v) + nw) {
                    d.put(nu + "," + nv, d.get(u + "," + v) + nw);
                    pq.offer(new int[] { nu, nv, d.get(nu + "," + nv) });
                }
            }
            final int eu = target[0];
            final int ev = target[1];
            final int ew = Math.abs(target[0] - u) + Math.abs(target[1] - v);
            if (d.getOrDefault(eu + "," + ev, (int) 1e9) > d.get(u + "," + v) + ew) {
                d.put(eu + "," + ev, d.get(u + "," + v) + ew);
                pq.offer(new int[] { eu, ev, d.get(eu + "," + ev) });
            }
        }
        return d.get(target[0] + "," + target[1]);
    }
}
