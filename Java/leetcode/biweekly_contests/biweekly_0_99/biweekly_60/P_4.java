package leetcode.biweekly_contests.biweekly_0_99.biweekly_60;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    static int[] f;
    static int[] masks;
    static boolean[][] seen;
    static long[][] dp;

    public int numberOfGoodSubsets(int[] nums) {
        final int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
        f = new int[31];
        for (int num : nums) {
            f[num]++;
        }
        masks = new int[31];
        seen = new boolean[31][1 << 10];
        dp = new long[31][1 << 10];
        for (int num = 2; num < masks.length; num++) {
            int mask = 0;
            for (int i = 0; i < primes.length; i++) {
                final int p = primes[i];
                if (num % p == 0) {
                    if (num % (p * p) == 0) {
                        mask = -1;
                        break;
                    }
                    mask |= 1 << i;
                }
            }
            masks[num] = mask;
        }
        final long ll = dfs(2, 0);
        final long mul = modPow(2, f[1]);
        final long res = (ll * mul) % MOD;
        return (int) res;
    }

    private static long modPow(long a, long n) {
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

    private static long dfs(int num, int mask) {
        if (num == 31) {
            return mask > 0 ? 1 : 0;
        }
        if (seen[num][mask]) {
            return dp[num][mask];
        }
        long res = 0;
        if (masks[num] != -1) {
            if ((mask & masks[num]) == 0) {
                final long add = f[num] * dfs(num + 1, mask | masks[num]);
                res = (res + add) % MOD;
            }
        }
        res = (res + dfs(num + 1, mask)) % MOD;
        seen[num][mask] = true;
        return dp[num][mask] = res;
    }
}
