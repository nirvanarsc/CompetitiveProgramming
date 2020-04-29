package weekly_contests.weekly_37;

public class P_625 {

    public int smallestFactorization(int a) {
        if (a < 10) {
            return a;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 2; i--) {
            while (a % i == 0) {
                sb.append(i);
                a /= i;
            }
        }
        if (a != 1) {
            return 0;
        }
        final long res = Long.valueOf(sb.reverse().toString());
        return res > Integer.MAX_VALUE ? 0 : (int) res;
    }
}
