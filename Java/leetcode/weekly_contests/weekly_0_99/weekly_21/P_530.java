package leetcode.weekly_contests.weekly_0_99.weekly_21;

import utils.DataStructures.TreeNode;

public class P_530 {

    TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        final int[] res = { Integer.MAX_VALUE };
        dfs(root, res);
        return res[0];
    }

    private void dfs(TreeNode node, int[] res) {
        if (node == null) {
            return;
        }
        dfs(node.left, res);
        if (prev != null) {
            res[0] = Math.min(res[0], Math.abs(node.val - prev.val));
        }
        prev = node;
        dfs(node.right, res);
    }
}
