package medium;

public class P_647 {

    public int countSubstrings(String s) {
        final boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;

        for (int col = 0; col < s.length(); col++) {
            for (int row = 0; row <= col; row++) {
                dp[row][col] = s.charAt(row) == s.charAt(col) && (col - row <= 2 || dp[row + 1][col - 1]);
                if (dp[row][col]) {
                    res++;
                }
            }
        }

        return res;
    }
}
