package leetcode.weekly_contests.weekly_226;

public class P_1744 {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        final int n = candiesCount.length;
        final long[] pre = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + candiesCount[i - 1];
        }
        final boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            final int type = queries[i][0];
            final int day = queries[i][1];
            final long limit = queries[i][2];
            res[i] = pre[type + 1] > day && limit * (day + 1) > pre[type];
        }
        return res;
    }
}

