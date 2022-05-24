package leetcode.weekly_contests.weekly_0_99.weekly_39;

public class P_634 {

    private static final int MOD = (int) (1e9 + 7);

    public int findDerangement(int n) {
        if (n == 1) {
            return 0;
        }
        long f = 0, s = 1;
        for (int k = 2; k < n; k++) {
            final long next = (k * (f + s)) % MOD;
            f = s;
            s = next;
        }
        return (int) s;
    }
}
