package leetcode.medium;

public class P_29 {

    public int divide(int dividend, int divisor) {
        if (Integer.MIN_VALUE == dividend && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        final boolean sign = dividend < 0 ^ divisor < 0;
        int a = Math.abs(dividend);
        final int b = Math.abs(divisor);
        int res = 0;
        while (a - b >= 0) {
            int currD = b;
            int count = 1;
            while (a - (currD << 1) >= 0) {
                currD <<= 1;
                count <<= 1;
            }
            a -= currD;
            res += count;
        }
        return sign ? -res : res;
    }
}
