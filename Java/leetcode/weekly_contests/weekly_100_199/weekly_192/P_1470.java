package leetcode.weekly_contests.weekly_100_199.weekly_192;

public class P_1470 {

    public int[] shuffle(int[] nums, int n) {
        final int[] res = new int[2 * n];
        for (int i = 0; i < n; ++i) {
            res[2 * i] = nums[i];
            res[2 * i + 1] = nums[i + n];
        }
        return res;
    }
}
