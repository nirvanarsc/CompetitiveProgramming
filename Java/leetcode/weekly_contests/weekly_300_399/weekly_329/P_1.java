package leetcode.weekly_contests.weekly_300_399.weekly_329;

public class P_1 {

    public int alternateDigitSum(int n) {
        int res = 0;
        int p = 1;
        while (n > 0) {
            res += p * (n % 10);
            p *= -1;
            n /= 10;
        }
        return p == 1 ? -res : res;
    }
}
