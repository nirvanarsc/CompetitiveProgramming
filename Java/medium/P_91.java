package medium;

public class P_91 {

    public int numDecodings(String s) {
        return recurse(s, 0, new Integer[s.length()]);
    }

    private static int recurse(String s, int start, Integer[] dp) {
        if (start >= s.length()) {
            return 1;
        }

        if (dp[start] != null) {
            return dp[start];
        }

        int one = 0;
        if (Integer.parseInt(s.substring(start, start + 1)) > 0) {
            one = recurse(s, start + 1, dp);
        }
        int two = 0;
        if (start + 2 <= s.length()) {
            final int num = Integer.parseInt(s.substring(start, start + 2));
            if (10 <= num && num <= 26) {
                two = recurse(s, start + 2, dp);
            }
        }

        return dp[start] = one + two;
    }
}
