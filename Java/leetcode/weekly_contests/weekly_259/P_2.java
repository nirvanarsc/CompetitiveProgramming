package leetcode.weekly_contests.weekly_259;

public class P_2 {

    public int sumOfBeauties(int[] nums) {
        int res = 0;
        final int n = nums.length;
        final int[] max = new int[n];
        final int[] min = new int[n];
        max[0] = nums[0];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i - 1], nums[i]);
        }
        min[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], nums[i]);
        }
        for (int i = 1; i < (n - 1); i++) {
            if (max[i - 1] < nums[i] && nums[i] < min[i + 1]) {
                res += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                res += 1;
            }
        }
        return res;
    }
}
