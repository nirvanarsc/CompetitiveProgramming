package leetcode.weekly_contests.weekly_300_399.weekly_308;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_4 {

    public static final int[] HAS_CYCLE = new int[0];
    public static final int[][] EMPTY = new int[0][0];

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        final int[] r = topSort(k, rowConditions);
        final int[] c = topSort(k, colConditions);
        if (r == HAS_CYCLE || c == HAS_CYCLE) {
            return EMPTY;
        }
        final int[] rr = new int[k + 1];
        final int[] cc = new int[k + 1];
        for (int i = 0; i < k; i++) {
            rr[r[i]] = i;
        }
        for (int i = 0; i < k; i++) {
            cc[c[i]] = i;
        }
        final int[][] res = new int[k][k];
        for (int i = 1; i <= k; i++) {
            res[rr[i]][cc[i]] = i;
        }
        return res;
    }

    private static int[] topSort(int k, int[][] c) {
        final Map<Integer, List<Integer>> g = new HashMap<>();
        final int[] inDeg = new int[k + 1];
        for (int[] e : c) {
            g.computeIfAbsent(e[0], val -> new ArrayList<>()).add(e[1]);
            inDeg[e[1]]++;
        }
        final Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= k; i++) {
            if (inDeg[i] == 0) {
                dq.offerLast(i);
            }
        }
        final int[] res = new int[k];
        int idx = 0;
        while (!dq.isEmpty()) {
            final int u = dq.removeFirst();
            res[idx++] = u;
            for (int v : g.getOrDefault(u, Collections.emptyList())) {
                if (--inDeg[v] == 0) {
                    dq.offerLast(v);
                }
            }
        }
        return idx == k ? res : HAS_CYCLE;
    }
}
