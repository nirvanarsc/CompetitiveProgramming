package leetcode.weekly_contests.weekly_300_399.weekly_324;

public class P_4 {

    public int[] cycleLengthQueries(int n, int[][] queries) {
        final int q = queries.length;
        final int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            final int u = queries[i][0];
            final int v = queries[i][1];
            res[i] = 1 + getDepth(u) + getDepth(v) - 2 * getDepth(getLca(u, v));
        }
        return res;
    }

    private static int getLca(int u, int v) {
        while (getDepth(u) > getDepth(v)) {
            u /= 2;
        }
        while (getDepth(v) > getDepth(u)) {
            v /= 2;
        }
        while (u != v) {
            u /= 2;
            v /= 2;
        }
        return u;
    }

    private static int getDepth(int u) {
        return 31 - Integer.numberOfLeadingZeros(u);
    }
}
