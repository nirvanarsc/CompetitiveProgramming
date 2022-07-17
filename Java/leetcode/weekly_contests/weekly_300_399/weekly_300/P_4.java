package leetcode.weekly_contests.weekly_300_399.weekly_300;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class P_4 {

    static int n;
    static int m;
    static List<int[]> edges;
    static int[][] g;

    private static final int[][] DIRS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    private static final int MOD = (int) (1e9 + 7);

    public int countPaths(int[][] grid) {
        edges = new ArrayList<>();
        n = grid.length;
        m = grid[0].length;
        final int[] inDeg = new int[n * m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int[] dir : DIRS) {
                    final int nx = i + dir[0];
                    final int ny = j + dir[1];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m && grid[i][j] < grid[nx][ny]) {
                        final int u = i * m + j;
                        final int v = nx * m + ny;
                        edges.add(new int[] { u, v });
                        inDeg[v]++;
                    }
                }
            }
        }
        g = packG();
        final Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n * m; i++) {
            if (inDeg[i] == 0) {
                dq.offerLast(i);
            }
        }
        final int[] topSort = new int[n * m];
        for (int idx = 0; !dq.isEmpty(); idx++) {
            final int u = dq.removeFirst();
            topSort[idx] = u;
            for (int v : g[u]) {
                if (--inDeg[v] == 0) {
                    dq.offerLast(v);
                }
            }
        }
        final int[] dp = new int[n * m];
        Arrays.fill(dp, 1);
        for (int i = n * m - 1; i >= 0; i--) {
            final int u = topSort[i];
            for (int v : g[u]) {
                dp[u] = (dp[u] + dp[v]) % MOD;
            }
        }
        int res = 0;
        for (int i = 0; i < n * m; i++) {
            res = (res + dp[i]) % MOD;
        }
        return res;
    }

    private static int[][] packG() {
        final int[][] g = new int[n * m][];
        final int[] size = new int[n * m];
        for (int[] edge : edges) {
            ++size[edge[0]];
        }
        for (int i = 0; i < n * m; i++) {
            g[i] = new int[size[i]];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = edge[1];
        }
        return g;
    }
}
