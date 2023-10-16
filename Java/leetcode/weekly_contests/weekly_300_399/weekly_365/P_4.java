package leetcode.weekly_contests.weekly_300_399.weekly_365;

import java.util.List;

public class P_4 {

    static int beforeLoc;
    static int len;
    static int n;
    static int[] res;
    static int[] prev;
    static int[] e;

    public int[] countVisitedNodes(List<Integer> edges) {
        n = edges.size();
        res = new int[n];
        prev = new int[n];
        e = edges.stream().mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < n; i++) {
            beforeLoc = (int) 1e9;
            len = 0;
            dfs(i, 1);
        }
        return res;
    }

    private static int dfs(int u, int currLength) {
        if (res[u] > 0) {
            return res[u];
        }
        if (prev[u] > 0) {
            beforeLoc = prev[u];
            len = currLength - beforeLoc;
            return 0;
        }
        prev[u] = currLength;
        final int next = dfs(e[u], currLength + 1);
        if (currLength >= beforeLoc) {
            res[u] = len;
        } else {
            res[u] = next + 1;
        }
        prev[u] = 0;
        return res[u];
    }
}
