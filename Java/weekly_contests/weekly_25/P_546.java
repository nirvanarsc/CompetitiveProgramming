package weekly_contests.weekly_25;

public class P_546 {

    public int removeBoxes(int[] boxes) {
        final int n = boxes.length;
        return left(boxes, 0, n - 1, 1, new Integer[n][n][n + 1]);
    }

    private static int left(int[] s, int i, int j, int k, Integer[][][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }
        while (i < j && s[i + 1] == s[i]) {
            i++;
            k++;
        }
        int res = k * k + left(s, i + 1, j, 1, dp);
        for (int m = i + 1; m <= j; m++) {
            if (s[m] == s[i]) {
                res = Math.max(res, left(s, i + 1, m - 1, 1, dp) + left(s, m, j, k + 1, dp));
            }
        }
        return dp[i][j][k] = res;
    }

    public int removeBoxesRight(int[] boxes) {
        final int n = boxes.length;
        return right(boxes, 0, n - 1, 1, new Integer[n][n][n + 1]);
    }

    private static int right(int[] s, int i, int j, int k, Integer[][][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }
        while (i < j && s[j - 1] == s[j]) {
            j--;
            k++;
        }
        int res = k * k + right(s, i, j - 1, 1, dp);
        for (int m = i; m < j; m++) {
            if (s[m] == s[j]) {
                res = Math.max(res, right(s, i, m, k + 1, dp) + right(s, m + 1, j - 1, 1, dp));
            }
        }
        return dp[i][j][k] = res;
    }
}
