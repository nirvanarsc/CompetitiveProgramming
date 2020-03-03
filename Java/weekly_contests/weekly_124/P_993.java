package weekly_contests.weekly_124;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ReturnOfNull", "ConstantConditions" })
public class P_993 {

    static class Pair {
        int depth;
        TreeNode parent;

        Pair(int depth, TreeNode parent) {
            this.depth = depth;
            this.parent = parent;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        final Pair p1 = findParent(root, null, x, 0);
        final Pair p2 = findParent(root, null, y, 0);
        return p1.depth == p2.depth && p1.parent != p2.parent;
    }

    private static Pair findParent(TreeNode node, TreeNode parent, int t, int d) {
        if (node == null) {
            return null;
        }

        if (node.val == t) {
            return new Pair(d, parent);
        }

        final Pair left = findParent(node.left, node, t, d + 1);
        final Pair right = findParent(node.right, node, t, d + 1);
        return left != null ? left : right;
    }
}
