package leetcode.weekly_contests.weekly_24;

import utils.DataStructures.TreeNode;

public class P_543 {

    public int diameterOfBinaryTree(TreeNode root) {
        return dfs(root)[0];
    }

    private static int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }
        final int[] left = dfs(node.left);
        final int[] right = dfs(node.right);
        final int max = Math.max(Math.max(left[0], right[0]), left[1] + right[1]);
        final int height = Math.max(left[1], right[1]) + 1;
        return new int[] { max, height };
    }
}
