package leetcode.weekly_contests.weekly_0_99.weekly_45;

public class P_660 {

    public int newInteger(int n) {
        int res = 0;
        int base = 1;
        while (n > 0) {
            res += n % 9 * base;
            base *= 10;
            n /= 9;
        }
        return res;
    }

    public int newIntegerString(int n) {
        return Integer.parseInt(Integer.toString(n, 9));
    }
}
