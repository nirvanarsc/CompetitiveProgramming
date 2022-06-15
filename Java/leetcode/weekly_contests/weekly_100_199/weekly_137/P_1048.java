package leetcode.weekly_contests.weekly_100_199.weekly_137;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1048 {

    static int n;
    static int[][] g;
    static List<int[]> edges;
    static int[] inDeg;

    public int longestStrChain(String[] words) {
        n = words.length;
        inDeg = new int[n];
        edges = new ArrayList<>();
        final Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(words[i], i);
        }
        for (String curr : words) {
            for (int j = 0; j < curr.length(); j++) {
                final String prev = curr.substring(0, j) + curr.substring(j + 1);
                if (map.containsKey(prev)) {
                    final int u = map.get(prev);
                    final int v = map.get(curr);
                    edges.add(new int[] { u, v });
                    inDeg[v]++;
                }
            }
        }
        g = packG();
        final int[] topSort = topSort();
        final int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            final int u = topSort[i];
            for (int v : g[u]) {
                dp[u] = Math.max(dp[u], dp[v] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res + 1;
    }

    private static int[] topSort() {
        final Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                dq.offerLast(i);
            }
        }
        final int[] res = new int[n];
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

    private static int[][] packG() {
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
}
