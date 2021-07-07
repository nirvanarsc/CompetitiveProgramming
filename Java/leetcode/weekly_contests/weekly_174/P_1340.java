package leetcode.weekly_contests.weekly_174;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class P_1340 {

    public int maxJumpsTS(int[] arr, int d) {
        final int n = arr.length;
        final int[] inDeg = new int[n];
        final List<List<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        monoQueue(arr, g, n, d);
        for (List<Integer> next : g) {
            for (int u : next) {
                inDeg[u]++;
            }
        }
        final int[] ts = topSort(inDeg, n, g);
        final int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = n - 1; i >= 0; i--) {
            final int u = ts[i];
            for (int v : g.get(u)) {
                if (dp[u] < dp[v] + 1) {
                    dp[u] = dp[v] + 1;
                    res = Math.max(res, dp[u]);
                }
            }
        }
        return res;
    }

    private static int[] topSort(int[] inDegrees, int n, List<List<Integer>> g) {
        final Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                q.offerLast(i);
            }
        }
        final int[] res = new int[n];
        for (int i = 0; !q.isEmpty(); i++) {
            final int curr = q.removeFirst();
            res[i] = curr;
            for (int next : g.get(curr)) {
                if (--inDegrees[next] == 0) {
                    q.offerLast(next);
                }
            }
        }
        return res;
    }

    private static void monoQueue(int[] arr, List<List<Integer>> g, int n, int d) {
        final Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && arr[i] > arr[dq.getFirst()]) {
                final int j = dq.removeFirst();
                if (i - j <= d) {
                    g.get(j).add(i);
                }
            }
            dq.addFirst(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!dq.isEmpty() && arr[i] > arr[dq.getFirst()]) {
                final int j = dq.removeFirst();
                if (j - i <= d) {
                    g.get(j).add(i);
                }
            }
            dq.addFirst(i);
        }
    }

    static boolean[] seen;
    static int[] dp;

    public int maxJumps(int[] arr, int d) {
        final int n = arr.length;
        seen = new boolean[n];
        dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                res = Math.max(res, dfs(arr, i, d));
            }
        }
        return res;
    }

    private static int dfs(int[] arr, int idx, int d) {
        if (seen[idx]) {
            return dp[idx];
        }
        int res = 1;
        for (int j = 1; j <= d && idx + j < arr.length; j++) {
            if (!(arr[idx] > arr[idx + j])) {
                break;
            }
            res = Math.max(res, 1 + dfs(arr, idx + j, d));
        }
        for (int j = 1; j <= d && idx - j >= 0; j++) {
            if (!(arr[idx] > arr[idx - j])) {
                break;
            }
            res = Math.max(res, 1 + dfs(arr, idx - j, d));
        }
        seen[idx] = true;
        return dp[idx] = res;
    }
}
