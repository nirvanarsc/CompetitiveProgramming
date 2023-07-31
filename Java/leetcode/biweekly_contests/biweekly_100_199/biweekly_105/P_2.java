package leetcode.biweekly_contests.biweekly_100_199.biweekly_105;

public class P_2 {

    static boolean[] seen;
    static int[] dp;

    public int minExtraChar(String s, String[] dictionary) {
        final int n = s.length();
        seen = new boolean[n];
        dp = new int[n];
        return dfs(s, 0, dictionary);
    }

    private static int dfs(String s, int idx, String[] dict) {
        if (idx >= s.length()) {
            return 0;
        }
        if (seen[idx]) {
            return dp[idx];
        }
        int res = (int) 1e9;
        for (String w : dict) {
            if (w.charAt(0) == s.charAt(idx)) {
                if (s.substring(idx, Math.min(s.length(), idx + w.length())).equals(w)) {
                    res = Math.min(res, dfs(s, idx + w.length(), dict));
                }
            }
        }
        res = Math.min(res, 1 + dfs(s, idx + 1, dict));
        seen[idx] = true;
        return dp[idx] = res;
    }
}
