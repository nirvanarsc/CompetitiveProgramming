package leetcode.weekly_contests.weekly_32;

import java.util.Arrays;

public class P_581 {

    public int findUnsortedSubarray(int[] nums) {
        final int[] clone = nums.clone();
        Arrays.sort(clone);
        int i = 0;
        int j = clone.length - 1;
        while (i < nums.length && nums[i] == clone[i]) {
            i++;
        }
        while (j >= 0 && nums[j] == clone[j]) {
            j--;
        }
        return j - i >= 0 ? j - i + 1 : 0;
    }
}
