package leetcode.weekly_contests.weekly_100_199.weekly_120;

public class P_978 {

    public int maxTurbulenceSizeBottomUp(int[] arr) {
        final int n = arr.length;
        final int[][] dp = new int[n][2];
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                dp[i][0] = dp[i - 1][1] + 1;
            } else if (arr[i - 1] > arr[i]) {
                dp[i][1] = dp[i - 1][0] + 1;
            }
            res = Math.max(res, dp[i][0]);
            res = Math.max(res, dp[i][1]);
        }
        return res + 1;
    }

    public int maxTurbulenceSize(int[] arr) {
        final int n = arr.length;
        int res = 1;
        int j = 0;
        for (int i = 1; i < n; i++) {
            final int sign = Integer.compare(arr[i - 1], arr[i]);
            if (sign == 0) {
                j = i;
            } else if (i == n - 1 || sign * Integer.compare(arr[i], arr[i + 1]) != -1) {
                res = Math.max(res, i - j + 1);
                j = i;
            }
        }
        return res;
    }
}
