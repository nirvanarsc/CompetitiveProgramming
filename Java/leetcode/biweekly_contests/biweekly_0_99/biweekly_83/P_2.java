package leetcode.biweekly_contests.biweekly_0_99.biweekly_83;

public class P_2 {

    public long zeroFilledSubarray(int[] nums) {
        final int n = nums.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int j = i;
                while (j < n && nums[j] == nums[i]) {
                    res += ++j - i;
                }
                i = j - 1;
            }
        }
        return res;
    }
}
