package leetcode.weekly_contests.weekly_400_499.weekly_442;

public class P_4 {

    static final long[] cache = new long[16];

    static {
        long count = 0;
        for (int i = 1; i < 16; i++) {
            cache[i] = count;
            count = (count << 2) + 3 * i;
        }
    }

    public long minOperations(int[][] queries) {
        long res = 0;
        for (int[] query : queries) {
            res += (f(query[1]) - f(query[0] - 1) + 1) >>> 1;
        }
        return res;
    }

    private static long f(int n) {
        final int bits = 16 - (Integer.numberOfLeadingZeros(n) >> 1);
        return (long) bits * n - cache[bits];
    }
}
