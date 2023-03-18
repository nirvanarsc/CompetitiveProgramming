package leetcode.biweekly_contests.biweekly_0_99.biweekly_80;

public class P_4 {

    public long countSubarrays(int[] nums, long k) {
        final int n = nums.length;
        int j = 0;
        long s = 0;
        long res = 0;
        for (int i = 0; i < n; i++) {
            s += nums[i];
            while (i - j + 1 > 0 && s >= (k + i - j) / (i - j + 1)) {
                s -= nums[j++];
            }
            res += i - j + 1;
        }
        return res;
    }
}
