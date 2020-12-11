package atcoder.beginner_100_199.beginner_169;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class F {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        final int s = in.nextInt();
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        final long[][] dp = new long[n + 1][s + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= s; j++) {
                dp[i + 1][j] += dp[i][j] * 2;
                if (j + arr[i] <= s) {
                    dp[i + 1][j + arr[i]] += dp[i][j];
                }
            }
            for (int j = 0; j <= s; j++) {
                dp[i + 1][j] %= MOD;
            }
        }
        System.out.println(dp[n][s]);
    }
}
