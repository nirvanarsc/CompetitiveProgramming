package leetcode.biweekly_contests.biweekly_100_199.biweekly_108;

public class P_1 {

    public int alternatingSubarray(int[] nums) {
        int res = 0;
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && (nums[j] - nums[j - 1]) == ((j - i) % 2 == 0 ? -1 : 1)) {
                j++;
            }
            res = Math.max(res, j - i);
        }
        return res == 1 ? -1 : res;
    }
}
