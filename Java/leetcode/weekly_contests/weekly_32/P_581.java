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
        final int[] stack = new int[n];
        int sIdx = 0;
        int l = n;
        int r = 0;
        for (int i = 0; i < n; i++) {
            while (sIdx > 0 && nums[stack[sIdx - 1]] > nums[i]) {
                l = Math.min(l, stack[--sIdx]);
            }
            stack[sIdx++] = i;
        }
        sIdx = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (sIdx > 0 && nums[stack[sIdx - 1]] < nums[i]) {
                r = Math.max(r, stack[--sIdx]);
            }
            stack[sIdx++] = i;
        }
        return Math.max(0, r - l + 1);
    }
}
