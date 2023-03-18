package leetcode.biweekly_contests.biweekly_0_99.biweekly_15;

public class P_1289 {

    public int minFallingPathSumOld(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int col = 0; col < arr[0].length; col++) {
                arr[i][col] += minWithoutCol(arr[i - 1], col);
            }
        }
        return minWithoutCol(arr[arr.length - 1], -1);
    }

    private static int minWithoutCol(int[] row, int ignoredCol) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row.length; i++) {
            if (i != ignoredCol) {
                min = Math.min(min, row[i]);
            }
        }
        return min;
    }

    public int minFallingPathSum(int[][] arr) {
        final int n = arr.length;
        final int m = arr[0].length;
        return dfs(arr, 0, m, new Integer[n][m + 1]);
    }

    public static int dfs(int[][] arr, int row, int prevCol, Integer[][] dp) {
        if (row == arr.length) {
            return 0;
        }
        if (dp[row][prevCol] != null) {
            return dp[row][prevCol];
        }
        int res = (int) 1e9;
        for (int col = 0; col < arr[row].length; col++) {
            if (col != prevCol) {
                res = Math.min(res, arr[row][col] + dfs(arr, row + 1, col, dp));
            }
        }
        return dp[row][prevCol] = res;
    }
}
