package codeforces.round_600_649.round_641;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class F {

    private static final int MOD = 998244353;
    private static final int N = (int) (5e3 + 5);

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        final long[][] dp = new long[N][N];
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + (i - j) * dp[i - 1][j - 1] % MOD) % MOD;
                }
                dp[i][j] = (dp[i][j] + (j + 1) * dp[i - 1][j] % MOD) % MOD;
            }
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + i * dp[i - 1][j - 1] % MOD) % MOD;
                }
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            System.out.print(dp[n][i] + " ");
        }
        System.out.println();
    }
}
