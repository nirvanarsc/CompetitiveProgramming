package leetcode.weekly_contests.weekly_200_299.weekly_263;

import java.util.Arrays;

public class P_1 {

    public boolean areNumbersAscending(String s) {
        final String[] split = s.split(" ");
        final int n = split.length;
        int[] nums = new int[n];
        int idx = 0;
        for (String value : split) {
            if (Character.isDigit(value.charAt(0))) {
                nums[idx++] = Integer.parseInt(value);
            }
        }
        nums = Arrays.copyOf(nums, idx);
        for (int i = 1; i < idx; i++) {
            if (nums[i] <= nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
