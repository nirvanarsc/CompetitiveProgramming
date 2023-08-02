package leetcode.biweekly_contests.biweekly_100_199.biweekly_106;

import java.util.Arrays;

public class P_3 {

    private static final int MOD = (int) (1e9 + 7);

    public int sumDistance(int[] nums, String s, int d) {
        final int n = nums.length;
        final long[] after = new long[n];
        for (int i = 0; i < n; i++) {
            after[i] = s.charAt(i) == 'R' ? ((long) nums[i] + d) : ((long) nums[i] - d);
        }
        Arrays.sort(after);
        final long diff = after[0];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            after[i] += diff;
            sum += after[i];
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            sum -= after[i];
            final long curr = sum - (n - i - 1) * after[i];
            res = (res + curr) % MOD;
        }
        return (int) res;
    }
}
