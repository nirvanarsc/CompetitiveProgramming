package leetcode.biweekly_contests.biweekly_100_199.biweekly_115;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_3 {

    static int[] dp;
    static boolean[] seen;
    static List<String> res;
    static Map<Integer, List<Integer>> g;
    static String[] w;

    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        res = new ArrayList<>();
        g = new HashMap<>();
        w = words;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (groups[i] != groups[j] &&
                    words[i].length() == words[j].length() &&
                    f(words[i], words[j]) == 1) {
                    g.computeIfAbsent(i, val -> new ArrayList<>()).add(j);
                }
            }
        }
        dp = new int[n];
        seen = new boolean[n];
        int best = -1;
        int bestIdx = -1;
        for (int i = 0; i < n; i++) {
            final int c = dfs(i);
            if (best < c) {
                best = c;
                bestIdx = i;
            }
        }
        res.add(w[bestIdx]);
        getPath(bestIdx);
        return res;
    }

    private static void getPath(int u) {
        if (!g.containsKey(u)) {
            return;
        }
        int best = -1;
        int bestIdx = -1;
        for (int v : g.get(u)) {
            if (best < 1 + dp[v]) {
                best = 1 + dp[v];
                bestIdx = v;
            }
        }
        res.add(w[bestIdx]);
        getPath(bestIdx);
    }

    private static int dfs(int u) {
        if (!g.containsKey(u)) {
            return 0;
        }
        if (seen[u]) {
            return dp[u];
        }
        int res = 0;
        for (int v : g.get(u)) {
            res = Math.max(res, 1 + dfs(v));
        }
        seen[u] = true;
        return dp[u] = res;
    }

    private static int f(String l, String r) {
        final int n = l.length();
        int diff = 0;
        for (int i = 0; i < n; i++) {
            diff += l.charAt(i) != r.charAt(i) ? 1 : 0;
        }
        return diff;
    }
}
