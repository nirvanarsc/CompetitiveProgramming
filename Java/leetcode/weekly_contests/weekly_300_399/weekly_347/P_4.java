package leetcode.weekly_contests.weekly_300_399.weekly_347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class P_4 {

    public int maxIncreasingCells(int[][] mat) {
        final int n = mat.length;
        final int m = mat[0].length;
        final TreeMap<Integer, List<Integer>> tm = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tm.computeIfAbsent(mat[i][j], val -> new ArrayList<>()).add(i * m + j);
            }
        }
        final int[] rows = new int[n];
        final int[] cols = new int[m];
        for (List<Integer> integers : tm.values()) {
            final Map<Integer, Integer> nr = new HashMap<>();
            final Map<Integer, Integer> nc = new HashMap<>();
            for (int u : integers) {
                final int r = u / m;
                final int c = u % m;
                final int next = Math.max(rows[r], cols[c]) + 1;
                nr.merge(r, next, Integer::max);
                nc.merge(c, next, Integer::max);
            }
            for (Map.Entry<Integer, Integer> entry : nr.entrySet()) { rows[entry.getKey()] = entry.getValue(); }
            for (Map.Entry<Integer, Integer> entry : nc.entrySet()) { cols[entry.getKey()] = entry.getValue(); }
        }
        int res = 0;
        for (int val : rows) {
            res = Math.max(res, val);
        }
        for (int val : cols) {
            res = Math.max(res, val);
        }
        return res;
    }
}
