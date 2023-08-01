package leetcode.weekly_contests.weekly_300_399.weekly_348;

public class P_2 {

    public int semiOrderedPermutation(int[] nums) {
        int l = -1;
        int r = -1;
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                l = i;
            } else if (nums[i] == n) {
                r = i;
            }
        }
        return l < r ? (l + (n - r - 1)) : (l + (n - r - 1) - 1);
    }
}
