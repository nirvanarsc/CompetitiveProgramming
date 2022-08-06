package leetcode.biweekly_contests.biweekly_84;

public class P_4 {

    public long minimumReplacement(int[] nums) {
        final int n = nums.length;
        long res = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                final int u = (nums[i] - 1) / nums[i + 1];
                res += u;
                nums[i] /= u + 1;
            }
        }
        return res;
    }
}
