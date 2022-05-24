package leetcode.weekly_contests.weekly_0_99.weekly_71;

import java.util.ArrayList;
import java.util.List;

import utils.DataStructures.TreeNode;

public class P_783 {

    public int minDiffInBSTBF(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        dfs(root, res);
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < res.size() - 1; i++) {
            min = Math.min(min, res.get(i + 1) - res.get(i));
        }
        return min;
    }

    private static void dfs(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        dfs(node.left, res);
        res.add(node.val);
        dfs(node.right, res);
    }

    int min = Integer.MAX_VALUE;
    TreeNode prev;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (prev != null) {
            min = Math.min(min, Math.abs(prev.val - node.val));
        }
        prev = node;
        dfs(node.right);
    }
}
