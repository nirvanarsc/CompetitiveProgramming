package leetcode.weekly_contests.weekly_100_199.weekly_186;

public class P_1423 {

    public int maxScore(int[] cardPoints, int k) {
        final int n = cardPoints.length;
        final int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + cardPoints[i - 1];
        }
        int res = 0;
        for (int i = 0; i <= k; i++) {
            res = Math.max(res, pre[i] + pre[n] - pre[n - (k - i)]);
        }
        return res;
    }
}
