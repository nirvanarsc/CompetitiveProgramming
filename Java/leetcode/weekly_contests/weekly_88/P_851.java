package leetcode.weekly_contests.weekly_88;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_851 {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        final Map<Integer, List<Integer>> g = new HashMap<>();
        final int[] res = new int[quiet.length];
        Arrays.fill(res, -1);
        for (int[] rich : richer) {
            g.computeIfAbsent(rich[1], v -> new ArrayList<>()).add(rich[0]);
        }
        for (int i = 0; i < quiet.length; i++) {
            res[i] = dfs(i, quiet, res, g);
        }
        return res;
    }

    private static int dfs(int i, int[] quiet, int[] res, Map<Integer, List<Integer>> g) {
        if (res[i] >= 0) {
            return res[i];
        }
        res[i] = i;
        for (int j : g.getOrDefault(i, Collections.emptyList())) {
            if (quiet[res[i]] > quiet[dfs(j, quiet, res, g)]) {
                res[i] = res[j];
            }
        }
        return res[i];
    }
}
