package leetcode.weekly_contests.weekly_300_399.weekly_320;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import utils.DataStructures.TreeNode;

public class P_2 {

    static TreeSet<Integer> ts;

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        ts = new TreeSet<>();
        dfs(root);
        final List<List<Integer>> res = new ArrayList<>();
        for (int u : queries) {
            final Integer l = ts.floor(u);
            final Integer r = ts.ceiling(u);
            res.add(Arrays.asList(l == null ? -1 : l, r == null ? -1 : r));
        }
        return res;
    }

    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        ts.add(root.val);
        dfs(root.right);
    }
}
