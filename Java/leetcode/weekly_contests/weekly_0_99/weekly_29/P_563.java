package leetcode.weekly_contests.weekly_0_99.weekly_29;

import utils.DataStructures.TreeNode;

public class P_563 {

    static int res;

    public int findTilt(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    private static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        final int l = dfs(node.left);
        final int r = dfs(node.right);
        res += Math.abs(l - r);
        return l + r + node.val;
    }
}
