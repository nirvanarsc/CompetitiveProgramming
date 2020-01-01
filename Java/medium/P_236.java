package medium;

import utils.DataStructures.TreeNode;

public class P_236 {

    static class Pair {
        TreeNode ancestor;
        int targetNodes;

        Pair(TreeNode ancestor, int targetNodes) {
            this.ancestor = ancestor;
            this.targetNodes = targetNodes;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q).ancestor;
    }

    private static Pair helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return new Pair(null, 0);
        }

        final Pair left = helper(node.left, p, q);
        if (left.targetNodes == 2) {
            return left;
        }
        final Pair right = helper(node.right, p, q);
        if (right.targetNodes == 2) {
            return right;
        }

        final int ancestors = left.targetNodes + right.targetNodes + (node == p ? 1 : 0) + (node == q ? 1 : 0);

        return new Pair(node, ancestors);
    }
}
