package leetcode.weekly_contests.weekly_300_399.weekly_326;

public class P_2 {

    public int distinctPrimeFactors(int[] nums) {
        final boolean[] seen = new boolean[1005];
        final int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37 };
        for (int num : nums) {
            for (int p : primes) {
                if (num % p == 0) {
                    seen[p] = true;
                    while (num % p == 0) {
                        num /= p;
                    }
                }
            }
            if (num > 1) {
                seen[num] = true;
            }
        }
        int res = 0;
        for (boolean isPrime : seen) {
            if (isPrime) {
                res++;
            }
        }
        return res;
    }
}
