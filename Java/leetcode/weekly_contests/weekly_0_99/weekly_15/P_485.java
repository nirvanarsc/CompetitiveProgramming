package leetcode.weekly_contests.weekly_0_99.weekly_15;

public class P_485 {

    public int findMaxConsecutiveOnesSW(int[] nums) {
        final int n = nums.length;
        int k = 0;
        int j = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            k -= nums[i] == 1 ? 0 : 1;
            while (k < 0) {
                k += nums[j++] == 1 ? 0 : 1;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        final int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                int j = i;
                while (j < n && nums[i] == nums[j]) {
                    j++;
                }
                res = Math.max(res, j - i);
                i = j - 1;
            }
        }
        return res;
    }
}
