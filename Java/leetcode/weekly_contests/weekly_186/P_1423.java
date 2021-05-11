package leetcode.weekly_contests.weekly_186;

public class P_1423 {

    public int maxScore(int[] cardPoints, int k) {
        final int n = cardPoints.length;
        final int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + cardPoints[i - 1];
        }
        int curr = 0;
        int res = pre[k];
        for (int i = n - 1, j = k - 1; j >= 0; i--, j--) {
            curr += cardPoints[i];
            res = Math.max(res, pre[j] + curr);
        }
        return res;
    }
}
