package leetcode.weekly_contests.weekly_218;

public class P_1681 {

    public int minimumIncompatibility(int[] nums, int k) {
        final int[] freq = new int[20];
        final int size = nums.length / k;
        int maxFreq = 0;
        for (int num : nums) {
            maxFreq = Math.max(maxFreq, ++freq[num]);
        }
        if (maxFreq > k) {
            return -1;
        }
        return dfs(nums, (1 << nums.length) - 1, size, new Integer[1 << nums.length]);

    }

    private static int dfs(int[] nums, int mask, int size, Integer[] dp) {
        if (mask == 0) {
            return 0;
        }
        if (dp[mask] != null) {
            return dp[mask];
        }
        int res = (int) 1e9;
        // https://cp-algorithms.com/algebra/all-submasks.html
        for (int subMask = mask; subMask > 0; subMask = (subMask - 1) & mask) {
            if (Integer.bitCount(subMask) == size) {
                int uniq = 0;
                boolean valid = true;
                for (int i = 0; i < nums.length; i++) {
                    if ((subMask & (1 << i)) != 0) {
                        if ((uniq & (1 << nums[i])) != 0) {
                            valid = false;
                            break;
                        }
                        uniq |= 1 << nums[i];
                    }
                }
                if (valid) {
                    int max = 0;
                    int min = (int) 1e9;
                    for (int j = 20; j >= 0; j--) {
                        if ((subMask & (1 << j)) != 0) {
                            max = Math.max(max, nums[j]);
                            min = Math.min(min, nums[j]);
                        }
                    }
                    res = Math.min(res, max - min + dfs(nums, mask ^ subMask, size, dp));
                }
            }
        }
        return dp[mask] = res;
    }
}
