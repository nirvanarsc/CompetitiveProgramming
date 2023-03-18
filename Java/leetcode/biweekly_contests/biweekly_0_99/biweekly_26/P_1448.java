package leetcode.biweekly_contests.biweekly_0_99.biweekly_26;

import utils.DataStructures.TreeNode;

public class P_1448 {

    static int res;

    public int goodNodes(TreeNode root) {
        res = 0;
        dfs(root, root.val);
        return res;
    }

    private static void dfs(TreeNode node, int max) {
        if (node == null) {
            return;
        }
        if (node.val >= max) {
            res++;
        }
        dfs(node.left, Math.max(max, node.val));
        dfs(node.right, Math.max(max, node.val));
    }
}
