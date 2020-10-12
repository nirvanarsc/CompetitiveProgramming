package leetcode.weekly_contests.weekly_52;

import utils.DataStructures.TreeNode;

public class P_687 {

    public int longestUnivaluePath(TreeNode root) {
        return dfs(root)[1];
    }

    private static int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }
        final int[] left = dfs(node.left);
        final int[] right = dfs(node.right);
        left[0] = (node.left != null && node.left.val == node.val) ? left[0] + 1 : 0;
        right[0] = (node.right != null && node.right.val == node.val) ? right[0] + 1 : 0;
        return new int[] {
                Math.max(left[0], right[0]), Math.max(Math.max(left[1], right[1]), left[0] + right[0])
        };
    }
}
