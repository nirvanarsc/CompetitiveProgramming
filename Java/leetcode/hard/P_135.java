package leetcode.hard;

public class P_135 {

    public int candy(int[] ratings) {
        final int n = ratings.length;
        final int[] dp = new int[n];
        for (int i = 0; i < n - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                dp[i + 1] = dp[i] + 1;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                dp[i - 1] = Math.max(dp[i - 1], dp[i] + 1);
            }
        }
        int res = n;
        for (int candy : dp) {
            res += candy;
        }
        return res;
    }
}
