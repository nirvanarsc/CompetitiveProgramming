package leetcode.medium;

import utils.DataStructures.TreeNode;

public class P_236 {

    private static class Pair {
        int mask;
        TreeNode lca;

        Pair(int mask, TreeNode lca) {
            this.mask = mask;
            this.lca = lca;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q).lca;
    }

    private static Pair dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Pair(0, null);
        }
        final Pair l = dfs(root.left, p, q);
        final Pair r = dfs(root.right, p, q);
        TreeNode lca = null;
        int mask;
        if (l.lca != null) {
            lca = l.lca;
            mask = 3;
        } else if (r.lca != null) {
            lca = r.lca;
            mask = 3;
        } else {
            mask = l.mask | r.mask;
            if (root == p) { mask |= 1; }
            if (root == q) { mask |= 2; }
            if (mask == 3) {
                lca = root;
            }
        }
        return new Pair(mask, lca);
    }
}
