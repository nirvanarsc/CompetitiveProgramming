package codeforces.round_600_649.round_642;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        final long[] dp = new long[(int) (5 * 1e5 + 5)];
        for (int i = 1; i < dp.length; i++) {
            final long curr = i * 2 + 1;
            dp[i] = dp[i - 1] + (4 * curr - 4) * i;
        }
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            System.out.println(dp[n / 2]);
        }
    }
}
