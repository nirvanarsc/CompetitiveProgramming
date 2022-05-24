package leetcode.weekly_contests.weekly_200_299.weekly_244;

public class P_3 {

    static int[][][] dp;
    static boolean[][][] seen;

    public int minFlips(String s) {
        final int used = s.length() % 2 == 0 ? 1 : 0;
        dp = new int[s.length()][2][2];
        seen = new boolean[s.length()][2][2];
        return Math.min(dfs(s.toCharArray(), 0, 0, used),
                        dfs(s.toCharArray(), 0, 1, used));
    }

    private static int dfs(char[] w, int idx, int type, int used) {
        if (idx == w.length) {
            return 0;
        }
        if (seen[idx][type][used]) {
            return dp[idx][type][used];
        }
        int res = (int) 1e9;
        if (type == 0) {
            if (w[idx] == '0') {
                res = Math.min(res, dfs(w, idx + 1, 1, used));
            } else {
                if (used == 0) {
                    res = Math.min(res, dfs(w, idx + 1, 0, 1));
                }
                res = Math.min(res, 1 + dfs(w, idx + 1, 1, used));
            }
        } else {
            if (w[idx] == '1') {
                res = Math.min(res, dfs(w, idx + 1, 0, used));
            } else {
                if (used == 0) {
                    res = Math.min(res, dfs(w, idx + 1, 1, 1));
                }
                res = Math.min(res, 1 + dfs(w, idx + 1, 0, used));
            }
        }
        seen[idx][type][used] = true;
        return dp[idx][type][used] = res;
    }
}
