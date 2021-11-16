package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_368 {

    static int maxSize;
    static int n;
    static int[] dp;

    public List<Integer> largestDivisibleSubset(int[] nums) {
        maxSize = 1;
        n = nums.length;
        dp = new int[n];
        Arrays.sort(nums);
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxSize = Math.max(maxSize, dp[i]);
                }
            }
        }
        return constructResult(nums);
    }

    private static List<Integer> constructResult(int[] nums) {
        int prev = -1;
        final List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == maxSize && (prev == -1 || prev % nums[i] == 0)) {
                res.add(nums[i]);
                prev = nums[i];
                maxSize--;
            }
        }
        return res;
    }
}
