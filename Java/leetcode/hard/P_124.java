package leetcode.hard;

import utils.DataStructures.TreeNode;

public class P_124 {

    static int res;

    public int maxPathSum(TreeNode root) {
        res = (int) -1e9;
        dfs(root);
        return res;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        final int leftMax = Math.max(0, dfs(root.left));
        final int rightMax = Math.max(0, dfs(root.right));
        res = Math.max(res, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}
