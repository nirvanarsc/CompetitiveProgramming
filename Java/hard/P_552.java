package hard;

public class P_552 {

    public static int mod = (int) (1e9 + 7);

    public int checkRecordBottomUp(int n) {
        long a0l0 = 1, a0l1 = 0, a0l2 = 0, a1l0 = 0, a1l1 = 0, a1l2 = 0;
        for (int i = 0; i <= n; i++) {
            final long a0l0_ = (a0l0 + a0l1 + a0l2) % mod;
            a0l2 = a0l1;
            a0l1 = a0l0;
            a0l0 = a0l0_;
            final long a1l0_ = (a0l0 + a1l0 + a1l1 + a1l2) % mod;
            a1l2 = a1l1;
            a1l1 = a1l0;
            a1l0 = a1l0_;
        }
        return (int) a1l0;
    }

    public int checkRecord(int n) {
        return recurse(0, n, false, false, false, new Integer[n][8]);
    }

    private static int recurse(int s, int n, boolean absent, boolean late1, boolean late2, Integer[][] dp) {
        if (s == n) {
            return 1;
        }
        int flag = 0;
        if (absent) { flag |= 1; }
        if (late1) { flag |= 2; }
        if (late2) { flag |= 4; }
        if (dp[s][flag] != null) {
            return dp[s][flag];
        }

        final int addPresent = recurse(s + 1, n, absent, false, late1, dp);
        final int addAbsent = absent ? 0 : recurse(s + 1, n, true, false, late1, dp);
        final int addLate = (late1 && late2) ? 0 : recurse(s + 1, n, absent, true, late1, dp);
        return dp[s][flag] = ((addPresent + addAbsent) % mod + addLate) % mod;
    }
}
