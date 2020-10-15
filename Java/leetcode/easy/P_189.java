package leetcode.easy;

public class P_189 {

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
