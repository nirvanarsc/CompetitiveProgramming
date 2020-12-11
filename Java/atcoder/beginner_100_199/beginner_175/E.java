package atcoder.beginner_100_199.beginner_175;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class E {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] line = in.nextLine().split(" ");
        final int r = Integer.parseInt(line[0]);
        final int c = Integer.parseInt(line[1]);
        final int K = Integer.parseInt(line[2]);
        final int[][] matrix = new int[r][c];
        for (int i = 0; i < K; i++) {
            line = in.nextLine().split(" ");
            final int row = Integer.parseInt(line[0]);
            final int col = Integer.parseInt(line[1]);
            final int v = Integer.parseInt(line[2]);
            matrix[row - 1][col - 1] = v;
        }
        final long[][][] dp = new long[r][c][4];
        dp[0][0][1] = matrix[0][0];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < 4; k++) {
                    if (i > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k]);
                        dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][j][k] + matrix[i][j]);
                    }
                    if (j > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k]);
                        if (k > 0) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k - 1] + matrix[i][j]);
                        }
                    }
                }
            }
        }
        long res = 0;
        for (long ans : dp[r - 1][c - 1]) {
            res = Math.max(res, ans);
        }
        System.out.println(res);
    }
}
