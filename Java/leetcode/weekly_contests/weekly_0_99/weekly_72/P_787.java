package leetcode.weekly_contests.weekly_0_99.weekly_72;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P_787 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        final Map<Integer, List<int[]>> g = new HashMap<>();
        for (int[] f : flights) {
            g.computeIfAbsent(f[0], v -> new ArrayList<>()).add(new int[] { f[1], f[2] });
        }
        pq.offer(new int[] { src, K + 1, 0 });
        while (!pq.isEmpty()) {
            final int[] curr = pq.poll();
            if (curr[0] == dst) {
                return curr[2];
            }
            for (int[] next : g.getOrDefault(curr[0], Collections.emptyList())) {
                if (curr[1] > 0) {
                    pq.add(new int[] { next[0], curr[1] - 1, curr[2] + next[1] });
                }
            }
        }
        return -1;
    }

    public int findCheapestPriceBF(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        for (int i = 0; i <= k; i++) {
            final int[] temp = cost.clone();
            for (int[] f : flights) {
                final int curr = f[0];
                final int next = f[1];
                final int price = f[2];
                if (cost[curr] == Integer.MAX_VALUE) {
                    continue;
                }
                temp[next] = Math.min(temp[next], cost[curr] + price);
            }
            cost = temp;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
