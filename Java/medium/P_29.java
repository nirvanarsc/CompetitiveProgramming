package medium;

public class P_29 {

    @SuppressWarnings("LocalCanBeFinal")
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = (dividend > 0) == (divisor > 0);
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int res = 0;
        while (a - b >= 0) {
            int x = 0;
            while (a - (b << 1 << x) >= 0) {
                x++;
            }
            res += 1 << x;
            a -= b << x;
        }
        return sign ? res : -res;
    }
}
