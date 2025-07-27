package leetcode.biweekly_contests.biweekly_100_199.biweekly_161;

public class P_4 {

    private static final long[][] C = new long[65][65];
    private static final int[] depth = new int[65];

    static {
        for (int i = 0; i < 65; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }
        for (int i = 2; i < 65; i++) {
            depth[i] = 1 + depth[Integer.bitCount(i)];
        }
    }

    public long popcountDepth(long n, int k) {
        if (k == 0) {
            return (n >= 1) ? 1 : 0;
        }
        long totalCount = 0;
        for (int p = 1; p <= 64; p++) {
            if (depth[p] == k - 1) {
                totalCount += count(n, p);
            }
        }
        if (k == 1) {
            totalCount--;
        }
        return totalCount;
    }

    private static long count(long n, int p) {
        final String s = Long.toBinaryString(n);
        final int len = s.length();
        long res = 0;
        int ones = 0;
        for (int i = 0; i < len; i++) {
            if (ones > p) {
                break;
            }
            if (s.charAt(i) == '1') {
                final int remainingLen = len - 1 - i;
                final int remainingOnes = p - ones;
                if (remainingOnes >= 0 && remainingOnes <= remainingLen) {
                    res += C[remainingLen][remainingOnes];
                }
                ones++;
            }
        }
        if (ones == p) {
            res++;
        }
        return res;
    }
}
