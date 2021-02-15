package foobar.level_3;

import java.util.Arrays;

@SuppressWarnings("UtilityClassWithoutPrivateConstructor")
public final class B {

    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
        System.out.println(solution(200));
    }

    public static int solution(int n) {
        final int[][] dp = new int[201][202];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(n, 201, dp);
    }

    private static int dfs(int n, int prev, int[][] dp) {
        if (n == 0) {
            return 1;
        }
        if (dp[n][prev] != -1) {
            return dp[n][prev];
        }
        int res = 0;
        if (prev == 201) {
            for (int curr = n - 1; curr >= 2; curr--) {
                res += dfs(n - curr, curr, dp);
            }
        } else {
            for (int curr = Math.min(n, prev - 1); curr >= 1; curr--) {
                res += dfs(n - curr, curr, dp);
            }
        }
        return dp[n][prev] = res;
    }
}

