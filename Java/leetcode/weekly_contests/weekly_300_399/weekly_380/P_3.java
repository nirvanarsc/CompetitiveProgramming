package leetcode.weekly_contests.weekly_300_399.weekly_380;

public class P_3 {

    public long findMaximumNumber(long k, int x) {
        long lo = 0;
        long hi = 1L << 50;
        while (lo < hi) {
            final long mid = lo + hi + 1 >>> 1;
            if (f(mid, x) > k) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    private static long f(long mid, int x) {
        long res = 0;
        for (int i = x; i <= 50; i += x) {
            res += countSetBitsAtPosition(mid, i);
        }
        return res;
    }

    public static long countSetBitsAtPosition(long n, int x) {
        // Convert 1-based index to 0-based
        final int adjustedX = x - 1;
        final long cycleLen = 1L << (adjustedX + 1);
        final long setLen = 1L << adjustedX;
        final long fullCycles = (n + 1) / cycleLen;
        final long remainder = (n + 1) % cycleLen;
        final long extra = Math.max(0, remainder - setLen);
        return fullCycles * setLen + extra;
    }
}
