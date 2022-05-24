package leetcode.weekly_contests.weekly_100_199.weekly_167;

public final class P_1292 {

    public static int maxSideLength(int[][] mat, int threshold) {
        if (mat.length == 0 || mat[0].length == 0) {
            return 0;
        }
        final int k = Math.min(mat.length, mat[0].length);
        int res = 0;
        for (int i = 0; i <= k; i++) {
            final int minSum = getMinSum(mat, i, threshold);
            if (minSum != Integer.MAX_VALUE) {
                res = i;
            } else {
                break;
            }
        }
        return res;
    }

    private static int getMinSum(int[][] mat, int k, int threshold) {
        final int n = mat.length;
        final int m = mat[0].length;
        int res = Integer.MAX_VALUE;
        if (k > n) {
            return res;
        }
        for (int i = 0; i < n - k + 1; i++) {
            for (int j = 0; j < m - k + 1; j++) {
                int sum = 0;
                for (int p = i; p < k + i; p++) {
                    for (int q = j; q < k + j; q++) {
                        sum += mat[p][q];
                    }
                }
                if (sum <= threshold) {
                    res = Math.min(res, sum);
                }
            }
        }
        return res;
    }

    public static int maxSideLength2(int[][] mat, int threshold) {
        final int n = mat.length;
        final int m = mat[0].length;
        // Find prefix sum
        final int[][] prefixSum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= m; j++) {
                sum += mat[i - 1][j - 1];
                prefixSum[i][j] = prefixSum[i - 1][j] + sum;
            }
        }
        // Start from largest side length
        for (int k = Math.min(n, m); k > 0; k--) {
            for (int i = 1; i + k <= n; i++) {
                for (int j = 1; j + k <= m; j++) {
                    if (prefixSum[i + k][j + k] -
                        prefixSum[i - 1][j + k] -
                        prefixSum[i + k][j - 1] +
                        prefixSum[i - 1][j - 1] <= threshold) {
                        return k + 1;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        final int[][] matrix = {
                { 1, 1, 3, 2, 4, 3, 2 },
                { 1, 1, 3, 2, 4, 3, 2 },
                { 1, 1, 3, 2, 4, 3, 2 }
        };

        System.out.println(maxSideLength(matrix, 4));
        System.out.println(maxSideLength2(matrix, 4));
    }

    private P_1292() {}
}
