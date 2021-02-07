package leetcode.weekly_contests.weekly_227;

import java.util.Arrays;

public class P_1752 {

    public boolean check(int[] nums) {
        final int[] clone = nums.clone();
        Arrays.sort(clone);
        for (int i = 0; i < nums.length; i++) {
            rotate(clone, 1);
            if (Arrays.equals(clone, nums)) {
                return true;
            }
        }
        return false;
    }

    public void rotate(int[] nums, int k) {
        final int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int from, int to) {
        while (from < to) {
            final int t = nums[from];
            nums[from] = nums[to];
            nums[to] = t;
            from++;
            to--;
        }
    }
}
