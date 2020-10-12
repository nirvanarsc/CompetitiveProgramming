package leetcode.hard;

public class P_479 {
    public int largestPalindrome(int n) {
        final int upper = (int) Math.pow(10, n) - 1;
        final int lower = upper / 10;
        for (int num = upper; num > lower; num--) {
            final StringBuilder sb = new StringBuilder(Integer.toString(num));
            final long temp = Long.valueOf(sb.toString() + sb.reverse());
            for (long p = upper; p * p > temp; p--) {
                if (temp % p == 0) {
                    return (int) (temp % 1337);
                }
            }
        }
        return 9;
    }
}
