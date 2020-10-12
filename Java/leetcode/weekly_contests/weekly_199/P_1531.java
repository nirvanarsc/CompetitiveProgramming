package leetcode.weekly_contests.weekly_199;

import java.util.ArrayList;
import java.util.List;

public class P_1531 {

    static class Pair {
        char c;
        int count;

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        final List<Pair> count = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            count.add(new Pair(s.charAt(i), j - i));
            i = j - 1;
        }
        return dfs(count, 0, 0, k, new Integer[count.size()][s.length()][k + 1]);
    }

    private static int dfs(List<Pair> count, int idx, int rem, int k, Integer[][][] dp) {
        if (idx == count.size()) {
            return 0;
        }
        if (dp[idx][rem][k] != null) {
            return dp[idx][rem][k];
        }
        final Pair curr = count.get(idx);
        final int c = curr.count + rem;
        int best = l(c) + dfs(count, idx + 1, 0, k, dp);
        for (int j = 1; j <= c && j <= k; j++) {
            best = Math.min(best, l(c - j) + dfs(count, idx + 1, 0, k - j, dp));
        }
        int temp = k;
        for (int j = idx + 1; j < count.size() && temp >= 0; j++) {
            if (count.get(j).c == curr.c) {
                best = Math.min(best, dfs(count, j, c, temp, dp));
            }
            temp -= count.get(j).count;
        }
        return dp[idx][rem][k] = best;
    }

    private static int l(int n) {
        if (n <= 1) { return n; }
        if (n < 10) { return 2; }
        if (n < 100) { return 3; }
        return 4;
    }
}
