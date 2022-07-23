package leetcode.biweekly_contests.biweekly_83;

public class P_2 {

    public long zeroFilledSubarray(int[] nums) {
        final int n = nums.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int j = i;
                while (j < n && nums[j] == nums[i]) {
                    j++;
                }
                final long l = j - i;
                res += (l * (l + 1)) / 2;
                i = j - 1;
            }
        }
        return res;
    }
}
