package leetcode.easy;

import utils.DataStructures.TreeNode;

public class P_110 {

    private static class Pair {
        int d;
        boolean isBalanced;

        Pair(int d, boolean isBalanced) {
            this.d = d;
            this.isBalanced = isBalanced;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root).isBalanced;
    }

    public Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair(0, true);
        }
        final Pair left = dfs(root.left);
        final Pair right = dfs(root.right);
        final boolean balanced = left.isBalanced && right.isBalanced && Math.abs(left.d - right.d) <= 1;
        return new Pair(Math.max(left.d, right.d) + 1, balanced);
    }
}
