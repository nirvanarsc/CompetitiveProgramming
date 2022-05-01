package leetcode.weekly_contests.weekly_291;

import java.util.HashSet;
import java.util.Set;

public class P_3 {

    private static final long MOD = 1L << 39;
    private static final int BASE = 100003;

    static long[] hash;
    static long[] pow;
    static int n;

    public int countDistinct(int[] nums, int k, int p) {
        n = nums.length;
        hash = new long[n + 1];
        pow = new long[n + 1];
        pow[0] = 1;
        final int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pow[i] = pow[i - 1] * BASE % MOD;
            hash[i] = (hash[i - 1] * BASE + nums[i - 1]) % MOD;
            pre[i] = pre[i - 1] + (nums[i - 1] % p == 0 ? 1 : 0);
        }
        final Set<Long> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (pre[j] - pre[i] <= k) {
                    res.add(getHash(i, j - 1));
                }
            }
        }
        return res.size();
    }

    // RabinKarp
    private static long getHash(int l, int r) {
        return (hash[r + 1] - (hash[l] * pow[r - l + 1]) % MOD + MOD) % MOD;
    }
}
