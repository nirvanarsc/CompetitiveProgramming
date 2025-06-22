package leetcode.weekly_contests.weekly_400_499.weekly_449;

public class P_2 {

    public boolean canPartitionGrid(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        long totalSum = 0;
        final long[] rowSums = new long[m];
        final long[] colSums = new long[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                final int val = grid[i][j];
                totalSum += val;
                rowSums[i] += val;
                colSums[j] += val;
            }
        }
        long currentSumA = 0;
        for (int i = 0; i < m - 1; i++) {
            currentSumA += rowSums[i];
            final long currentSumB = totalSum - currentSumA;
            if (currentSumA == currentSumB) {
                return true;
            }
        }
        currentSumA = 0;
        for (int j = 0; j < n - 1; j++) {
            currentSumA += colSums[j];
            final long currentSumB = totalSum - currentSumA;
            if (currentSumA == currentSumB) {
                return true;
            }
        }
        return false;
    }
}
