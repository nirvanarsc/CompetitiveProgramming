package leetcode.biweekly_contests.biweekly_0_99.biweekly_61;

import java.util.Arrays;

public class P_4 {

    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        final int n = nums.length;
        int j = 0;
        int max = 0;
        int dup = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                dup++;
            }
            while (j < n && nums[i] >= nums[j] + n) {
                if (j > 0 && nums[j - 1] == nums[j]) {
                    dup--;
                }
                j++;
            }
            max = Math.max(max, (i - j + 1) - dup);
        }
        return n - max;
    }
}
