package leetcode.weekly_contests.weekly_300_399.weekly_372;

public class P_3 {

    private static final int MOD = (int) (1e9 + 7);

    public int maximumXorProduct(long a, long b, int n) {
        long x = 0;
        for (int i = 0; i < n; i++) {
            if (((a & (1L << i)) | (b & (1L << i))) == 0) {
                x |= 1L << i;
            }
        }
        a ^= x;
        b ^= x;
        for (int i = 50; i >= 0; i--) {
            if (((a & (1L << i)) ^ (b & (1L << i))) != 0) {
                if ((a & (1L << i)) != 0) {
                    for (int j = Math.min(i - 1, n - 1); j >= 0; j--) {
                        if (((a & (1L << j)) ^ (b & (1L << j))) != 0) {
                            if ((a & (1L << j)) != 0) {
                                a ^= 1L << j;
                                b ^= 1L << j;
                            }
                        }
                    }
                } else {
                    for (int j = Math.min(i - 1, n - 1); j >= 0; j--) {
                        if (((a & (1L << j)) ^ (b & (1L << j))) != 0) {
                            if ((b & (1L << j)) != 0) {
                                a ^= 1L << j;
                                b ^= 1L << j;
                            }
                        }
                    }
                }
                break;
            }
        }
        a %= MOD;
        b %= MOD;
        return (int) ((a * b) % MOD);
    }
}
