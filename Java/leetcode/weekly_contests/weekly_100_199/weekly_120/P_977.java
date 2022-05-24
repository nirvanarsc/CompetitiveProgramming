package leetcode.weekly_contests.weekly_100_199.weekly_120;

public class P_977 {

    public int[] sortedSquares(int[] nums) {
        final int[] res = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int idx = res.length - 1;
        while (i <= j) {
            final int l = nums[i] * nums[i];
            final int r = nums[j] * nums[j];
            if (l < r) {
                res[idx] = r;
                j--;
            } else {
                res[idx] = l;
                i++;
            }
            idx--;
        }
        return res;
    }
}
