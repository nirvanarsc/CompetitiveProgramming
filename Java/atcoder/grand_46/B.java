package atcoder.grand_46;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int a = in.nextInt();
        final int b = in.nextInt();
        final int c = in.nextInt();
        final int d = in.nextInt();
        System.out.println(dfs(a, b, c, d, new Integer[c + 1][d + 1]));
    }

    private static long dfs(int a, int b, int c, int d, Integer[][] dp) {
        if (a == c && b == d) {
            return 1; 
        }
        if (dp[a][b] != null) {
            return dp[a][b];
        }
        int res = 0;
        if (a < c) {
            res += Math.floorMod(b * dfs(a + 1, b, c, d, dp), MOD);
        }
        if (b < d) {
            res += Math.floorMod(a * dfs(a, b + 1, c, d, dp), MOD);
        }
        if (a < c && b < d) {
            res -= Math.floorMod(a * b * dfs(a + 1, b + 1, c, d, dp), MOD);
        }
        return dp[a][b] = Math.floorMod(res, MOD);
    }
}
