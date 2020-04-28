package weekly_contests.weekly_39;

public class P_633 {

    public boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
            final int sqrt = (int) Math.sqrt(c - i * i);
            if (sqrt * sqrt == c - i * i) {
                return true;
            }
        }
        return false;
    }
}
