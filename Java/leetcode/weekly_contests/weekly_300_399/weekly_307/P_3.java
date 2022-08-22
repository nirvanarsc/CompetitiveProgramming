package leetcode.weekly_contests.weekly_300_399.weekly_307;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.DataStructures.TreeNode;

public class P_3 {

    static Map<Integer, List<Integer>> g;

    public int amountOfTime(TreeNode root, int start) {
        g = new HashMap<>();
        dfs(root, -1);
        final Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[] { start, -1 });
        int res;
        for (res = -1; !dq.isEmpty(); res++) {
            for (int size = dq.size(); size > 0; size--) {
                final int[] c = dq.removeFirst();
                for (int v : g.getOrDefault(c[0], Collections.emptyList())) {
                    if (v != c[1]) {
                        dq.offerLast(new int[] { v, c[0] });
                    }
                }
            }
        }
        return res;
    }

    private static void dfs(TreeNode u, int p) {
        if (u == null) {
            return;
        }
        if (p != -1) {
            g.computeIfAbsent(u.val, val -> new ArrayList<>()).add(p);
            g.computeIfAbsent(p, val -> new ArrayList<>()).add(u.val);
        }
        dfs(u.left, u.val);
        dfs(u.right, u.val);
    }
}
