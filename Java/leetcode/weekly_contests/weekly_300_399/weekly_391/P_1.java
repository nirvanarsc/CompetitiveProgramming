package leetcode.weekly_contests.weekly_300_399.weekly_391;

public class P_1 {

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        final int c = x;
        int d = 0;
        while (x > 0) {
            d += x % 10;
            x /= 10;
        }
        return c % d == 0 ? d : -1;
    }
}
