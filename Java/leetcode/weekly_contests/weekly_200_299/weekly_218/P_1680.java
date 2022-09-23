package leetcode.weekly_contests.weekly_200_299.weekly_218;

public class P_1680 {

    private static final int MOD = (int) (1e9 + 7);

    public int concatenatedBinary(int n) {
        long res = 0;
        for (int u = 1; u <= n; u++) {
            final int msb = Integer.highestOneBit(u);
            res = (res * (msb << 1)) % MOD;
            res = (res + u) % MOD;
        }
        return (int) res;
    }
}
