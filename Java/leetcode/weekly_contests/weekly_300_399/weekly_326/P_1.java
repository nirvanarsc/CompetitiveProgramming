package leetcode.weekly_contests.weekly_300_399.weekly_326;

public class P_1 {

    public int countDigits(int num) {
        final int n = num;
        int res = 0;
        while (num > 0) {
            final int c = num % 10;
            num /= 10;
            if (n % c == 0) {
                res++;
            }
        }
        return res;
    }
}
