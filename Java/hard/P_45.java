package hard;

import java.util.Arrays;

public class P_45 {

    public int jumpGreedy(int[] nums) {
        int jumps = 0, currEnd = 0, currFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currFarthest = Math.max(currFarthest, i + nums[i]);
            if (i == currEnd) {
                jumps++;
                currEnd = currFarthest;
            }
        }
        return jumps;
    }

    public int jump(int[] nums) {
        final int[] dp = new int[nums.length];
        final int MAX_VALUE = (int) 1e9;
        Arrays.fill(dp, MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            int t = MAX_VALUE;
            final int right = Math.min(nums.length - 1, i + nums[i]);
            for (int x = i; x <= right; x++) {
                t = Math.min(t, dp[x]);
            }
            dp[right] = Math.min(dp[right], t + 1);
        }
        return dp[nums.length - 1];
    }
}
