package medium;

public class P_1027 {

    public int longestArithSeqLength(int[] ints) {
        int res = 2;
        final int n = ints.length;
        final int[][] dp = new int[n][20001];
        for (int j = 0; j < ints.length; j++) {
            for (int i = 0; i < j; i++) {
                final int d = ints[j] - ints[i] + 10001;
                if (dp[i][d] == 0) {
                    dp[j][d] = 2;
                } else {
                    dp[j][d] = dp[i][d] + 1;
                }
                res = Math.max(res, dp[j][d]);
            }
        }
        return res;
    }
}
