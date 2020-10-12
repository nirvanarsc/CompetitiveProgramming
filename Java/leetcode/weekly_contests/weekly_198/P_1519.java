package leetcode.weekly_contests.weekly_198;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1519 {

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], l -> new ArrayList<>()).add(e[1]);
            g.computeIfAbsent(e[1], l -> new ArrayList<>()).add(e[0]);
        }
        final int[] res = new int[n];
        final boolean[] seen = new boolean[n];
        dfs(g, 0, labels, res, seen);
        return res;
    }

    private static int[] dfs(Map<Integer, List<Integer>> g, int curr, String labels, int[] res, boolean[] seen) {
        final int[] cnt = new int[26];
        if (!seen[curr]) {
            seen[curr] = true;
            for (int child : g.getOrDefault(curr, Collections.emptyList())) {
                final int[] sub = dfs(g, child, labels, res, seen);
                for (int i = 0; i < 26; ++i) {
                    cnt[i] += sub[i];
                }
            }
            res[curr] = ++cnt[labels.charAt(curr) - 'a'];
        }
        return cnt;
    }
}
