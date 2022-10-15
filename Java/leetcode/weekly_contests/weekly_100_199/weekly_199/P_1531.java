package leetcode.weekly_contests.weekly_100_199.weekly_199;

import java.util.ArrayList;
import java.util.List;

public class P_1531 {

    static boolean[][][] seen;
    static int[][][] dp;

    public int getLengthOfOptimalCompression(String s, int k) {

        final List<int[]> count = new ArrayList<>();
        final int m = s.length();
        for (int i = 0; i < m; i++) {
            int j = i;
            while (j < m && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            count.add(new int[] { s.charAt(i) - 'a', j - i });
            i = j - 1;
        }
        final int n = count.size();
        seen = new boolean[n][m][k + 1];
        dp = new int[n][m][k + 1];
        return dfs(count, 0, 0, k);
    }

    private static int dfs(List<int[]> count, int idx, int rem, int k) {
        if (idx == count.size()) {
            return 0;
        }
        if (seen[idx][rem][k]) {
            return dp[idx][rem][k];
        }
        final int[] curr = count.get(idx);
        final int c = curr[1] + rem;
        int res = l(c) + dfs(count, idx + 1, 0, k);
        for (int j = 1; j <= c && j <= k; j++) {
            res = Math.min(res, l(c - j) + dfs(count, idx + 1, 0, k - j));
        }
        int temp = k;
        for (int j = idx + 1; j < count.size() && temp >= 0; j++) {
            if (count.get(j)[0] == curr[0]) {
                res = Math.min(res, dfs(count, j, c, temp));
            }
            temp -= count.get(j)[1];
        }
        seen[idx][rem][k] = true;
        return dp[idx][rem][k] = res;
    }

    private static int l(int n) {
        if (n <= 1) { return n; }
        if (n < 10) { return 2; }
        if (n < 100) { return 3; }
        return 4;
    }
}
