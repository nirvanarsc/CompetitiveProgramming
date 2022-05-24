package leetcode.weekly_contests.weekly_100_199.weekly_135;

public class P_1039 {

    public int minScoreTriangulation(int[] A) {
        return recurse(A, 0, A.length - 1, new Integer[A.length][A.length]);
    }

    private static int recurse(int[] nums, int i, int j, Integer[][] dp) {
        if (j - i < 2) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res, nums[i] * nums[j] * nums[k]
                                + recurse(nums, i, k, dp)
                                + recurse(nums, k, j, dp));
        }
        return dp[i][j] = res;
    }
}
