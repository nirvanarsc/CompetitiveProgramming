package leetcode.biweekly_contests.biweekly_100_199.biweekly_107;

import java.util.Arrays;

public class P_3 {

    static boolean[][][] seen;
    static int[][][] dp;

    public int minimizeConcatenatedLength(String[] words) {
        final int n = words.length;
        seen = new boolean[26][26][n];
        dp = new int[26][26][n];
        final int sum = Arrays.stream(words).map(String::length).reduce(0, Integer::sum);
        return sum - dfs(words[0].charAt(0) - 'a', words[0].charAt(words[0].length() - 1) - 'a', 1, words);
    }

    private static int dfs(int first, int last, int idx, String[] words) {
        if (idx == words.length) {
            return 0;
        }
        if (seen[first][last][idx]) {
            return dp[first][last][idx];
        }
        int res = 0;
        final int nextFirst = words[idx].charAt(0) - 'a';
        final int nextLast = words[idx].charAt(words[idx].length() - 1) - 'a';
        res = Math.max(res, (nextLast == first ? 1 : 0) + dfs(nextFirst, last, idx + 1, words));
        res = Math.max(res, (last == nextFirst ? 1 : 0) + dfs(first, nextLast, idx + 1, words));
        seen[first][last][idx] = true;
        return dp[first][last][idx] = res;
    }
}
