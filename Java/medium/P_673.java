package medium;

public class P_673 {

    public int findNumberOfLIS(int[] nums) {
        final int[][] dp = new int[nums.length][2];
        int lisLength = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j][0] + 1 > dp[i][0]) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    } else if (dp[j][0] + 1 == dp[i][0]) {
                        dp[i][1] += dp[j][1];
                    }
                }
            }
            lisLength = Math.max(lisLength, dp[i][0]);
        }
        for (int[] ints : dp) {
            if (ints[0] == lisLength) {
                res += ints[1];
            }
        }
        return res;
    }
}
