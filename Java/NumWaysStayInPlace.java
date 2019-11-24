public final class NumWaysStayInPlace {

    public static int numWays(int steps, int arrLen) {
        arrLen = Math.min(arrLen, steps);
        final int mod = 1000000000 + 7;
        final int[][] dp = new int[steps + 1][arrLen];

        dp[1][0] = 1;
        dp[1][1] = 1;

        for (int step = 2; step <= steps; step++) {
            for (int pos = 0; pos < arrLen; pos++) {
                final int inPlace = dp[step - 1][pos];
                final int left = pos - 1 >= 0 ? dp[step - 1][pos - 1] : 0;
                final int right = pos + 1 < arrLen ? dp[step - 1][pos + 1] : 0;
                dp[step][pos] += left;
                dp[step][pos] %= mod;
                dp[step][pos] += right;
                dp[step][pos] %= mod;
                dp[step][pos] += inPlace;
                dp[step][pos] %= mod;
            }
        }
        return dp[steps][0];
    }

    public static void main(String[] args) {
        System.out.println(numWays(27, 7));
    }

    private NumWaysStayInPlace() {}
}
