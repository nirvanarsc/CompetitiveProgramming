package leetcode.weekly_contests.weekly_300_399.weekly_344;

public class P_3 {

    public int[] colorTheArray(int n, int[][] queries) {
        final int q = queries.length;
        final int[] res = new int[q];
        final int[] c = new int[n];
        int curr = 0;
        for (int i = 0; i < q; i++) {
            final int u = queries[i][0];
            final int v = queries[i][1];
            if (u > 0 && c[u - 1] == c[u] && c[u] != 0) { curr--; }
            if (u < (n - 1) && c[u] == c[u + 1] && c[u] != 0) { curr--; }
            c[u] = v;
            if (u > 0 && c[u - 1] == c[u]) { curr++; }
            if (u < (n - 1) && c[u] == c[u + 1]) { curr++; }
            res[i] = curr;
        }
        return res;
    }
}
