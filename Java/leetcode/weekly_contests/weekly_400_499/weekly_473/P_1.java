package leetcode.weekly_contests.weekly_400_499.weekly_473;

public class P_1 {

    public long removeZeros(long n) {
        final StringBuilder res = new StringBuilder();
        while (n > 0) {
            final int u = (int) (n % 10);
            if (u != 0) {
                res.append(u);
            }
            n /= 10;
        }
        return Long.valueOf(res.reverse().toString());
    }
}
