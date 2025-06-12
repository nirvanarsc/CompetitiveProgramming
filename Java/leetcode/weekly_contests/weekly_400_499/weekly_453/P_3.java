package leetcode.weekly_contests.weekly_400_499.weekly_453;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_3 {

    private static final int MOD = (int) (1e9 + 7);

    public int countPartitions(int[] nums, int k) {
        final int n = nums.length;
        final int[] dp = new int[n + 1];
        final Deque<Integer> max = new ArrayDeque<>();
        final Deque<Integer> min = new ArrayDeque<>();
        int l = 0;
        int curr = dp[0] = 1;
        for (int r = 0; r < n; r++) {
            while (!max.isEmpty() && nums[r] >= nums[max.getLast()]) { max.removeLast(); }
            max.addLast(r);
            while (!min.isEmpty() && nums[r] <= nums[min.getLast()]) { min.removeLast(); }
            min.offerLast(r);
            while (nums[max.getFirst()] - nums[min.getFirst()] > k) {
                if (max.getFirst() == l) { max.removeFirst(); }
                if (min.getFirst() == l) { min.removeFirst(); }
                curr = (curr - dp[l++] + MOD) % MOD;
            }
            dp[r + 1] = curr;
            curr = (curr + dp[r + 1]) % MOD;
        }
        return dp[n];
    }
}
