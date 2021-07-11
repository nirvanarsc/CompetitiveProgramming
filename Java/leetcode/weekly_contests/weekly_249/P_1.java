package leetcode.weekly_contests.weekly_249;

public class P_1 {

    public int[] getConcatenation(int[] nums) {
        final int n = nums.length;
        final int[] res = new int[2 * n];
        System.arraycopy(nums, 0, res, 0, n);
        System.arraycopy(nums, 0, res, n, 2 * n - n);
        return res;
    }
}
