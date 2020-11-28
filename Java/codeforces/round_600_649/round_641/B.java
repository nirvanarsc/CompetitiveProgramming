package codeforces.round_600_649.round_641;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int[] dp = new int[100010];
            final int[] s = new int[100010];
            for (int a = 1; a <= n; ++a) { s[a] = in.nextInt(); }
            Arrays.fill(dp, 1);
            int res = 0;
            for (int a = 1; a <= n; ++a) {
                for (int b = a * 2; b <= n; b += a) {
                    if (s[b] > s[a]) {
                        dp[b] = Math.max(dp[b], dp[a] + 1);
                    }
                }
                res = Math.max(res, dp[a]);
            }
            System.out.println(res);
        }
    }
}
