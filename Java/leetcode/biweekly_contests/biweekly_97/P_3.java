package leetcode.biweekly_contests.biweekly_97;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P_3 {

    static Map<Integer, Integer> normalized;
    static TreeMap<Integer, Integer> tm;
    static boolean[][] seen;
    static int[][] dp;

    public int maximizeWin(int[] prizePositions, int k) {
        tm = new TreeMap<>();
        for (int p : prizePositions) {
            tm.merge(p, 1, Integer::sum);
        }
        int totalV = 0;
        tm.put(0, 0);
        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            totalV += entry.getValue();
            tm.put(entry.getKey(), totalV);
        }
        final int[] indices = tm.keySet().stream().mapToInt(Integer::intValue).sorted().skip(1).toArray();
        normalized = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            normalized.put(indices[i], i);
        }
        seen = new boolean[indices.length][3];
        dp = new int[indices.length][3];
        return dfs(indices, 0, 2, k);
    }

    private static int dfs(int[] indices, int idx, int open, int k) {
        if (open == 0 || idx == indices.length) {
            return 0;
        }
        if (seen[idx][open]) {
            return dp[idx][open];
        }
        int res = 0;
        res = Math.max(res, dfs(indices, idx + 1, open, k));
        final int l = indices[idx];
        final int r = l + k;
        final Map.Entry<Integer, Integer> ll = tm.lowerEntry(l);
        final Map.Entry<Integer, Integer> rr = tm.floorEntry(r);
        final int add = rr.getValue() - ll.getValue();
        res = Math.max(res, add + dfs(indices, normalized.get(rr.getKey()) + 1, open - 1, k));
        seen[idx][open] = true;
        return dp[idx][open] = res;
    }
}
