package leetcode.weekly_contests.weekly_32;

import java.util.Arrays;

public class P_581 {

    public int findUnsortedSubarraySort(int[] nums) {
        final int[] clone = nums.clone();
        Arrays.sort(clone);
        final int n = nums.length;
        int i = 0;
        int j = n - 1;
        while (i < n && nums[i] == clone[i]) {
            i++;
        }
        while (j >= 0 && nums[j] == clone[j]) {
            j--;
        }
        return Math.max(0, j - i + 1);
    }

    public int findUnsortedSubarray(int[] nums) {
        final int n = nums.length;
        int i = -1;
        int j = -2;
        int min = nums[n - 1];
        int max = nums[0];
        for (int k = 1; k < n; k++) {
            max = Math.max(max, nums[k]);
            min = Math.min(min, nums[n - 1 - k]);
            if (nums[k] < max) {
                j = k;
            }
            if (nums[n - 1 - k] > min) {
                i = n - 1 - k;
            }
        }
        return j - i + 1;
    }
}
