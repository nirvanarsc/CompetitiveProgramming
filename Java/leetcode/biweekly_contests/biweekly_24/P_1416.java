package leetcode.biweekly_contests.biweekly_24;

public class P_1416 {

    private static final int MOD = (int) (1e9 + 7);

    public int numberOfArrays(String s, int k) {
        return recurse(s, k, 0, new Integer[s.length()]);
    }

    private static int recurse(String s, int k, int start, Integer[] dp) {
        if (start == s.length()) {
            return 1;
        }
        if (s.charAt(start) == '0') {
            return 0;
        }
        if (dp[start] != null) {
            return dp[start];
        }
        int res = 0;
        long num = 0;
        for (int i = start; i < Math.min(start + 10, s.length()); i++) {
            num = num * 10 + s.charAt(i) - '0';
            if (num <= k) {
                res = (res + recurse(s, k, i + 1, dp)) % MOD;
            }
        }
        return dp[start] = res;
    }
}
