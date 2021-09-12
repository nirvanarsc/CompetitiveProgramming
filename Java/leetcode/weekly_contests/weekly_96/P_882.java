package leetcode.weekly_contests.weekly_96;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P_882 {

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        final int[][] g = new int[n][n];
        final boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], -1);
        }
        for (int[] edge : edges) {
            g[edge[0]][edge[1]] = edge[2];
            g[edge[1]][edge[0]] = edge[2];
        }
        int res = 0;
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        pq.offer(new int[] { 0, maxMoves });
        while (!pq.isEmpty()) {
            final int[] curr = pq.poll();
            final int u = curr[0];
            final int move = curr[1];
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            res++;
            for (int v = 0; v < n; v++) {
                if (g[u][v] > -1) {
                    if (move > g[u][v] && !visited[v]) {
                        pq.offer(new int[] { v, move - g[u][v] - 1 });
                    }
                    g[v][u] -= Math.min(move, g[u][v]);
                    res += Math.min(move, g[u][v]);
                }
            }
        }
        return res;
    }
}
