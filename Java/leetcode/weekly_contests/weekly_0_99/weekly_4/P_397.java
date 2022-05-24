package leetcode.weekly_contests.weekly_0_99.weekly_4;

public class P_397 {

    public int integerReplacement(int n) {
        int res = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
                --n;
            } else {
                ++n;
            }
            ++res;
        }
        return res;
    }
}
