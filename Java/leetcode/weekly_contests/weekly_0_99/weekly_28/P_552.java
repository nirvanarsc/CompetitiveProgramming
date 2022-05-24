package leetcode.weekly_contests.weekly_0_99.weekly_28;

import java.util.Arrays;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_552 {

    private static final int MOD = (int) (1e9 + 7);

    public int checkRecord(int n) {
        return recurse(n, 0, 0, 0, new Integer[n][2][3]);
    }

    private static int recurse(int n, int curr, int a, int l, Integer[][][] dp) {
        if (curr == n) {
            return 1;
        }
        if (dp[curr][a][l] != null) {
            return dp[curr][a][l];
        }
        int absent = 0;
        if (a == 0) {
            absent = recurse(n, curr + 1, 1, 0, dp);
        }
        int late = 0;
        if (l < 2) {
            late = recurse(n, curr + 1, a, l + 1, dp);
        }
        final int present = recurse(n, curr + 1, a, 0, dp);
        return dp[curr][a][l] = ((absent + late) % MOD + present) % MOD;
    }

    public int checkRecordBottomUp(int n) {
        final int[][][] dp = new int[n + 1][2][3];
        Arrays.fill(dp[0][0], 1);
        Arrays.fill(dp[0][1], 1);
        for (int i = 1; i <= n; i++) {
            for (int a = 0; a < 2; a++) {
                for (int l = 0; l < 3; l++) {
                    final int present = dp[i - 1][a][2];
                    int absent = 0;
                    if (a > 0) {
                        absent = dp[i - 1][a - 1][2];
                    }
                    int late = 0;
                    if (l > 0) {
                        late = dp[i - 1][a][l - 1];
                    }
                    dp[i][a][l] = ((absent + late) % MOD + present) % MOD;
                }
            }
        }
        return dp[n][1][2];
    }

    public int checkRecordBottomUpSpace(int n) {
        long a0l0 = 1, a0l1 = 0, a0l2 = 0, a1l0 = 0, a1l1 = 0, a1l2 = 0;
        for (int i = 0; i <= n; i++) {
            final long a0l0_ = (a0l0 + a0l1 + a0l2) % MOD;
            a0l2 = a0l1;
            a0l1 = a0l0;
            a0l0 = a0l0_;
            final long a1l0_ = (a0l0 + a1l0 + a1l1 + a1l2) % MOD;
            a1l2 = a1l1;
            a1l1 = a1l0;
            a1l0 = a1l0_;
        }
        return (int) a1l0;
    }

    public int checkRecordBoolean(int n) {
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
        return dp[s][flag] = ((addPresent + addAbsent) % MOD + addLate) % MOD;
    }

    private static int[][] mul(int[][] A, int[][] B) {
        final int M = A.length;
        final int[][] C = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < M; k++) {
                    C[i][j] = (int) ((C[i][j] + (long) A[i][k] * B[k][j]) % MOD);
                }
            }
        }
        return C;
    }

    private static int[][] pow(int[][] A, int n) {
        final int M = A.length;
        int[][] res = new int[M][M];
        for (int i = 0; i < M; i++) {
            res[i][i] = 1;
        }
        while (n > 0) {
            if (n % 2 == 1) {
                res = mul(res, A);
            }
            A = mul(A, A);
            n >>= 1;
        }
        return res;
    }

    public int checkRecordMatrix(int n) {
        final int[][] A = {
                { 0, 0, 1, 0, 0, 0 },
                { 1, 0, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 1 },
                { 0, 0, 1, 1, 0, 1 },
                { 0, 0, 1, 0, 1, 1 },
                };
        return pow(A, n + 1)[5][2];
    }
}
