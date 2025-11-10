package leetcode.biweekly_contests.biweekly_100_199.biweekly_168;

@SuppressWarnings("NonThreadSafeLazyInitialization")
public class P_4 {

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int[][] gcd;

    private static final int MOD = (int) (1e9 + 7);

    public int countCoprime(int[][] mat) {
        if (gcd == null) {
            gcd = new int[151][151];
            for (int i = 0; i < 151; i++) {
                for (int j = 0; j < 151; j++) {
                    gcd[i][j] = gcd(i, j);
                }
            }
        }
        final int n = mat.length;
        final int m = mat[0].length;
        final int[][] dp = new int[n][151];
        for (int i = 0; i < m; i++) {
            dp[0][mat[0][i]]++;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 151; k++) {
                    dp[i][gcd[mat[i][j]][k]] = (dp[i][gcd[mat[i][j]][k]] + dp[i - 1][k]) % MOD;
                }
            }
        }
        return dp[n - 1][1];
    }
}
