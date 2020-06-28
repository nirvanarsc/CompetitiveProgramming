package weekly_contests.weekly_195;

import java.util.Arrays;

public class P_1498 {

    private static final int MOD = (int) (1e9 + 7);

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        long res = 0;
        while (i <= j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else {
                res = (res + modpow(2, j - i)) % MOD;
                i++;
            }
        }
        return (int) res;
    }

    private static long modpow(long a, long n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            n /= 2;
        }
        return res;
    }
}
