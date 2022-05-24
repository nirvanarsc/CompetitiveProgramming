package leetcode.weekly_contests.weekly_0_99.weekly_24;

import utils.DataStructures.TreeNode;

public class P_538 {

    public TreeNode convertBST(TreeNode root) {
        dfs(root, new int[] { 0 });
        return root;
    }

    private static void dfs(TreeNode node, int[] curr) {
        if (node == null) {
            return;
        }
        dfs(node.right, curr);
        final int temp = node.val;
        node.val += curr[0];
        curr[0] += temp;
        dfs(node.left, curr);
    }
}
