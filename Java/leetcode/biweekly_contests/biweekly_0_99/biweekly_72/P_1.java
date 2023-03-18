package leetcode.biweekly_contests.biweekly_0_99.biweekly_72;

public class P_1 {

    public int countPairs(int[] nums, int k) {
        int res = 0;
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
