package leetcode.weekly_contests.weekly_200_299.weekly_242;

public class P_1872 {

    public int stoneGameVIII(int[] stones) {
        final int n = stones.length;
        final long[] pre = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + stones[i - 1];
        }
        long res = pre[n];
        for (int i = n - 1; i >= 2; i--) {
            res = Math.max(res, pre[i] - res);
        }
        return (int) res;
    }
}
