package medium;

import utils.DataStructures.TreeNode;

public class P_1123 {

    static class Pair {
        TreeNode node;
        int depth;

        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return recurse(root, 0).node;
    }

    private static Pair recurse(TreeNode root, int depth) {
        if (root == null) {
            return new Pair(null, depth);
        }
        final Pair l = recurse(root.left, depth + 1);
        final Pair r = recurse(root.right, depth + 1);
        if (l.depth == r.depth) {
            return new Pair(root, l.depth);
        } else {
            return l.depth > r.depth ? l : r;
        }
    }
}
