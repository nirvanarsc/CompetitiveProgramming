package leetcode.weekly_contests.weekly_300_399.weekly_357;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P_4 {

    public long findMaximumElegance(int[][] items, int k) {
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] item : items) {
            g.computeIfAbsent(item[1], val -> new ArrayList<>()).add(item[0]);
        }
        for (List<Integer> v : g.values()) {
            v.sort(Comparator.naturalOrder());
        }
        long curr = 0;
        final Map<Integer, Integer> seen = new HashMap<>();
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        final PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (Map.Entry<Integer, List<Integer>> e : g.entrySet()) {
            pq.offer(new int[] { e.getKey(), e.getValue().get(e.getValue().size() - 1) });
            seen.merge(e.getKey(), 1, Integer::sum);
            curr += e.getValue().get(e.getValue().size() - 1);
            if (pq.size() > k) {
                final int[] pop = pq.remove();
                curr -= pop[1];
                if (seen.merge(pop[0], -1, Integer::sum) == 0) {
                    seen.remove(pop[0]);
                }
            }
        }
        for (int[] item : pq) {
            g.get(item[0]).remove(g.get(item[0]).size() - 1);
            if (g.get(item[0]).isEmpty()) {
                g.remove(item[0]);
            }
        }
        for (Map.Entry<Integer, List<Integer>> e : g.entrySet()) {
            for (int u : e.getValue()) {
                pq2.offer(new int[] { e.getKey(), u });
            }
        }
        long res = curr + (long) seen.keySet().size() * seen.keySet().size();
        while (!pq2.isEmpty()) {
            final int[] pop = pq2.remove();
            pq.offer(pop);
            seen.merge(pop[0], 1, Integer::sum);
            curr += pop[1];
            if (pq.size() > k) {
                final int[] pop2 = pq.remove();
                curr -= pop2[1];
                if (seen.merge(pop2[0], -1, Integer::sum) == 0) {
                    seen.remove(pop2[0]);
                }
            }
            res = Math.max(res, curr + (long) seen.keySet().size() * seen.keySet().size());
        }
        return res;
    }
}
