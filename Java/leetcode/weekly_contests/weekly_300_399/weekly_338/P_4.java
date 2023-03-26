package leetcode.weekly_contests.weekly_300_399.weekly_338;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;

public class P_4 {

    public int collectTheCoins(int[] coins, int[][] edges) {
        final int n = coins.length;
        //noinspection unchecked
        final HashSet<Integer>[] g = new HashSet[n];
        for (int i = 0; i < n; i++) {
            g[i] = new HashSet<>();
        }
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        final int[] jumps = new int[n];
        final int[] dist = new int[n];
        Arrays.fill(dist, 2);
        final Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (g[i].size() == 1 && coins[i] == 0) {
                q.offerLast(i);
            }
        }
        while (!q.isEmpty()) {
            final int u = q.removeFirst();
            if (g[u].isEmpty()) {
                continue;
            }
            final int v = g[u].iterator().next();
            g[u].clear();
            g[v].remove(u);
            if (g[v].size() == 1 && coins[v] == 0) {
                q.offerLast(v);
            }
        }
        for (int i = 0; i < n; i++) {
            if (g[i].size() == 1) {
                q.offerLast(i);
            }
        }
        while (!q.isEmpty()) {
            final int u = q.removeFirst();
            if (g[u].isEmpty()) {
                return jumps[u];
            }
            final int v = g[u].iterator().next();
            g[u].clear();
            g[v].remove(u);
            if (jumps[u] > 0) {
                jumps[v] += jumps[u] + 2;
            } else if (dist[u] == 0) {
                jumps[v] += 2;
            } else {
                dist[v] = Math.min(dist[v], dist[u] - 1);
            }
            if (g[v].size() == 1) {
                q.add(v);
            }
        }
        return 0;
    }
}
