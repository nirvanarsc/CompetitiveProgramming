package leetcode.weekly_contests.weekly_273;

public class P_1 {

    public boolean isSameAfterReversals(int num) {
        return num == f(f(num));
    }

    private static int f(int num) {
        int res = 0;
        while (num > 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res;
    }
}
