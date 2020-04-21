package weekly_contests.weekly_49;

public class P_673 {

    public int findNumberOfLIS(int[] nums) {
        final int[][] dp = new int[nums.length][2];
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i][0] < dp[j][0] + 1) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    } else if (dp[i][0] == dp[j][0] + 1) {
                        dp[i][1] += dp[j][1];
                    }
                }
            }
            max = Math.max(max, dp[i][0]);
        }
        for (int[] row : dp) {
            if (row[0] == max) {
                count += row[1];
            }
        }
        return count;
    }
}
