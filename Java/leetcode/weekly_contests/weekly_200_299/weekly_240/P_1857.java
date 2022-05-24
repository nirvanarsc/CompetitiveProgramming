package leetcode.weekly_contests.weekly_200_299.weekly_240;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P_1857 {

    public int largestPathValue(String colors, int[][] edges) {
        final int n = colors.length();
        final int[][] g = packG(edges, n);
        final int[] inDeg = new int[n];
        for (int[] edge : edges) {
            inDeg[edge[1]]++;
        }
        final int[] topSort = topSort(g, inDeg, n);
        for (int i = 0; i < n; i++) {
            if (topSort[i] == -1) {
                return -1;
            }
        }
        final int[][] dp = new int[n][26];
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            final int u = topSort[i];
            res = Math.max(res, ++dp[u][colors.charAt(u) - 'a']);
            for (int v : g[u]) {
                for (int j = 0; j < 26; j++) {
                    dp[u][j] = Math.max(dp[u][j], dp[v][j] + (j == colors.charAt(u) - 'a' ? 1 : 0));
                    res = Math.max(res, dp[u][j]);
                }
            }
        }
        return res;
    }

    private static int[][] packG(int[][] edges, int n) {
        final int[][] g = new int[n][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = edge[1];
        }
        return g;
    }

    private static int[] topSort(int[][] g, int[] inDeg, int n) {
        final Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                dq.offerLast(i);
            }
        }
        final int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; !dq.isEmpty(); i++) {
            final int u = dq.removeFirst();
            res[i] = u;
            for (int v : g[u]) {
                if (--inDeg[v] == 0) {
                    dq.offerLast(v);
                }
            }
        }
        return res;
    }
}
