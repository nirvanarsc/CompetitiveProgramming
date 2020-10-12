package leetcode.easy;

public class P_9 {

    public boolean isPalindrome(int x) {
        return x >= 0 && x == reverse(x);
    }

    public int reverse(int x) {
        final boolean sign = x < 0;
        int rev = 0;
        x = Math.abs(x);
        while (x > 0) {
            if (rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return sign ? -1 * rev : rev;
    }
}
