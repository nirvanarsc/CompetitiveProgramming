package leetcode.weekly_contests.weekly_300_399.weekly_315;

public class P_3 {

    public boolean sumOfNumberAndReverse(int num) {
        for (int u = 0; u <= num; u++) {
            if (u + rev(u) == num) {
                return true;
            }
        }
        return false;
    }

    private static int rev(int n) {
        int res = 0;
        while (n > 0) {
            res = res * 10 + n % 10;
            n /= 10;
        }
        return res;
    }
}
