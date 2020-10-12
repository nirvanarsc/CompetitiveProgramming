package leetcode.medium;

public final class P_63 {

    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        final int m = obstacleGrid[0].length;
        final int[] dp = new int[m];
        dp[0] = 1;

        for (int[] row : obstacleGrid) {
            for (int j = 0; j < m; j++) {
                if (row[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[m - 1];
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1) {
            return 1;
        }
        final int n = obstacleGrid.length;
        final int m = obstacleGrid[0].length;
        boolean flag = false;

        for (int i = 1; i < n; i++) {
            if (obstacleGrid[i][0] == 1) {
                flag = true;
            }
            obstacleGrid[i][0] = flag ? 0 : 1;
        }
        flag = false;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[0][i] == 1) {
                flag = true;
            }
            obstacleGrid[0][i] = flag ? 0 : 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }

        return obstacleGrid[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][] { { 0, 1 } }));
    }

    private P_63() {}
}
