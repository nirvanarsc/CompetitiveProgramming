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

    // Top Down TLE 85773
    public int checkRecord(int n) {
        return recurse(0, n, false, false, false, new Integer[n][2][2][2]);
    }

    private static int recurse(int s, int n, boolean wasAbsent, boolean latePrev, boolean latePrevPrev,
                               Integer[][][][] dp) {
        if (s == n) {
            return 1;
        }
        final int latePP = latePrevPrev ? 1 : 0;
        final int lateP = latePrev ? 1 : 0;
        final int absent = wasAbsent ? 1 : 0;
        if (dp[s][absent][lateP][latePP] != null) {
            return dp[s][absent][lateP][latePP];
        }

        final int addPresent = recurse(s + 1, n, wasAbsent, false, latePrev, dp);
        final int addAbsent = wasAbsent ? 0 : recurse(s + 1, n, true, false, latePrev, dp);
        final int addLate = (latePrev && latePrevPrev) ? 0 : recurse(s + 1, n, wasAbsent, true, latePrev, dp);
        dp[s][absent][lateP][latePP] = addAbsent;
        dp[s][absent][lateP][latePP] %= mod;
        dp[s][absent][lateP][latePP] += addLate;
        dp[s][absent][lateP][latePP] %= mod;
        dp[s][absent][lateP][latePP] += addPresent;
        dp[s][absent][lateP][latePP] %= mod;
        return dp[s][absent][lateP][latePP];
    }
}
