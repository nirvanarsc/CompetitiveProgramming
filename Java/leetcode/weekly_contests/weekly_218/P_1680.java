package leetcode.weekly_contests.weekly_218;

public class P_1680 {

    private static final int MOD = (int) (1e9 + 7);

    public int concatenatedBinary(int n) {
        long res = 0;
        for (int i = 1; i <= n; i++) {
            final int msb = Integer.highestOneBit(i) << 1;
            res = (res * msb) % MOD;
            res = (res + i) % MOD;
        }
        return (int) res;
    }
}
