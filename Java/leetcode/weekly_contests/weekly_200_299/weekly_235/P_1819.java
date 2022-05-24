package leetcode.weekly_contests.weekly_200_299.weekly_235;

public class P_1819 {

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int countDifferentSubsequenceGCDs(int[] nums) {
        final int[] factors = new int[(int) (2e5 + 5)];
        int res = 0;
        for (int num : nums) {
            for (int p = 1; (long) p * p <= num; p++) {
                if (num % p == 0) {
                    if (num / p != p) {
                        factors[p] = gcd(factors[p], num);
                    }
                    factors[num / p] = gcd(factors[num / p], num);
                }
            }
        }
        for (int i = 1; i < factors.length; i++) {
            if (factors[i] == i) {
                res++;
            }
        }
        return res;
    }
}
