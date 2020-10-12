package leetcode.weekly_contests.weekly_186;

public class P_1423 {

    public int maxScore(int[] cardPoints, int k) {
        final int len = cardPoints.length;
        int j = len - k;
        int res = 0, sum = 0;
        for (int start = len - k; start < len + k; start++) {
            sum += cardPoints[start % len];
            if (start - j == k) {
                sum -= cardPoints[j++ % len];
            }
            res = Math.max(sum, res);
        }
        return res;
    }

    public int maxScorePreSum(int[] cardPoints, int k) {
        final int[] sums = new int[cardPoints.length];
        int sum = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            sum += cardPoints[i];
            sums[i] = sum;
        }
        if (k == sums.length) {
            return sum;
        }
        int max = 0;
        for (int i = 0; i <= k; i++) {
            final int curr = (i == 0 ? 0 : sums[i - 1]) + (sum - sums[sums.length - 1 + i - k]);
            max = Math.max(max, curr);
        }
        return max;
    }
}
