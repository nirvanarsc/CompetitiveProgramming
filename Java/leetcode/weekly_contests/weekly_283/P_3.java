package leetcode.weekly_contests.weekly_283;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.DataStructures.TreeNode;

public class P_3 {

    static List<List<int[]>> g;
    static int[] val;
    static int[] p;

    public TreeNode createBinaryTree(int[][] descriptions) {
        final Map<Integer, Integer> idx = new HashMap<>();
        final int n = descriptions.length;
        p = new int[n + 1];
        val = new int[n + 1];
        g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        Arrays.fill(p, -1);
        int i = 0;
        for (int[] e : descriptions) {
            final int u = e[0];
            final int v = e[1];
            final int l = e[2];
            Integer uid = idx.get(u);
            Integer vid = idx.get(v);
            if (uid == null) {
                uid = i;
                idx.put(u, i++);
            }
            if (vid == null) {
                vid = i;
                idx.put(v, i++);
            }
            val[uid] = u;
            val[vid] = v;
            g.get(uid).add(new int[] { vid, l });
            p[vid] = uid;
        }
        int root = -1;
        for (int j = 0; j <= n; j++) {
            if (p[j] == -1) {
                root = j;
            }
        }
        return dfs(root);
    }

    private static TreeNode dfs(int u) {
        final TreeNode node = new TreeNode(val[u]);
        for (int[] v : g.get(u)) {
            if (v[1] == 1) {
                node.left = dfs(v[0]);
            } else {
                node.right = dfs(v[0]);
            }
        }
        return node;
    }
}
