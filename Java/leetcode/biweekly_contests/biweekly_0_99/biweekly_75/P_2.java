package leetcode.biweekly_contests.biweekly_0_99.biweekly_75;

public class P_2 {

    public int triangularSum(int[] nums) {
        final int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            final int[] next = new int[n - 1 - i];
            for (int j = 0; j < next.length; j++) {
                next[j] = (nums[j] + nums[j + 1]) % 10;
            }
            nums = next;
        }
        return nums[0];
    }
}
