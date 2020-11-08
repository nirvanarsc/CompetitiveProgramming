package leetcode.weekly_contests.weekly_29;

import utils.DataStructures.TreeNode;

public class P_563 {

    public int findTilt(TreeNode root) {
        return dfs(root)[1];
    }

    private static int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }
        final int[] ll = dfs(node.left);
        final int[] rr = dfs(node.right);
        final int sum = ll[0] + rr[0] + node.val;
        return new int[] { sum, ll[1] + rr[1] + Math.abs(ll[0] - rr[0]) };
    }
}
