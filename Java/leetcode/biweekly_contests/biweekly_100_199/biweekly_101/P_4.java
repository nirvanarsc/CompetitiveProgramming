package leetcode.biweekly_contests.biweekly_100_199.biweekly_101;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P_4 {

    static int n;
    static int[][] edges;
    static int[][] g;
    static int[] d;

    public int findShortestCycle(int n, int[][] edges) {
        //noinspection AccessStaticViaInstance
        this.n = n;
        //noinspection AccessStaticViaInstance
        this.edges = edges;
        g = packG();
        int res = (int) 1e9;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, bfs(i));
        }
        return res == (int) 1e9 ? -1 : res;
    }

    private static int bfs(int s) {
        final Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(s);
        d = new int[n];
        Arrays.fill(d, (int) 1e9);
        d[s] = 0;
        int res = (int) 1e9;
        while (!dq.isEmpty()) {
            final int u = dq.removeFirst();
            for (int v : g[u]) {
                if (d[v] == (int) 1e9) {
                    d[v] = d[u] + 1;
                    dq.offerLast(v);
                } else if (d[u] <= d[v]) {
                    res = Math.min(res, d[v] + d[u] + 1);
                }
            }
        }
        return res;
    }

    private static int[][] packG() {
        final int[][] g = new int[n][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
            ++size[edge[1]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = edge[1];
            g[edge[1]][--size[edge[1]]] = edge[0];
        }
        return g;
    }
}
