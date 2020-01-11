package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P_787 {

    public int findCheapestPriceDijkstra(int n, int[][] flights, int src, int dst, int k) {
        final Map<Integer, List<int[]>> g = new HashMap<>();
        for (int[] flight : flights) {
            g.putIfAbsent(flight[0], new ArrayList<>());
            g.get(flight[0]).add(new int[] { flight[1], flight[2] });
        }
        final PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        q.offer(new int[] { 0, src, k + 1 });
        while (!q.isEmpty()) {
            final int[] c = q.poll();
            final int cost = c[0];
            final int curr = c[1];
            final int stop = c[2];
            if (curr == dst) { return cost; }
            if (stop > 0) {
                if (!g.containsKey(curr)) { continue; }
                for (int[] next : g.get(curr)) {
                    q.add(new int[] { cost + next[1], next[0], stop - 1 });
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
