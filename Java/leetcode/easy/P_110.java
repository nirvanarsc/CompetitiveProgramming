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

    private static Pair dfs(TreeNode node) {
        if (node == null) {
            return new Pair(0, true);
        }
        final Pair left = dfs(node.left);
        final Pair right = dfs(node.right);
        final int d = 1 + Math.max(left.d, right.d);
        final boolean isBalanced = Math.abs(left.d - right.d) <= 1 && left.isBalanced && right.isBalanced;
        return new Pair(d, isBalanced);
    }
}
