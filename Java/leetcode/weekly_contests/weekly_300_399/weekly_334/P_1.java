package leetcode.weekly_contests.weekly_300_399.weekly_334;

public class P_1 {

    public int[] leftRigthDifference(int[] nums) {
        int r = 0;
        for (int num : nums) {
            r += num;
        }
        final int n = nums.length;
        final int[] res = new int[n];
        int l = 0;
        for (int i = 0; i < n; i++) {
            l += i == 0 ? 0 : nums[i - 1];
            r -= nums[i];
            res[i] = Math.abs(l - r);
        }
        return res;
    }
}
