package leetcode.weekly_contests.weekly_0_99.weekly_74;

public class P_795 {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        final int n = nums.length;
        return f(nums, n, right) - f(nums, n, left - 1);
    }

    private static int f(int[] nums, int n, int max) {
        final int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            map[i] = nums[i] > max ? 1 : 0;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (map[i] == 0) {
                int j = i;
                while (j < n && map[j] == 0) {
                    j++;
                }
                final int count = j - i;
                res += (count * (count + 1)) / 2;
                i = j - 1;
            }
        }
        return res;
    }
}
