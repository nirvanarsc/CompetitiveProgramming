package leetcode.weekly_contests.weekly_92;

import utils.DataStructures.TreeNode;

public class P_865 {

    static class Pair {
        int depth;
        TreeNode ans;

        Pair(int depth, TreeNode ans) {
            this.depth = depth;
            this.ans = ans;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).ans;
    }

    private static Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair(0, null);
        }
        final Pair left = dfs(root.left);
        final Pair right = dfs(root.right);
        if (left.depth == right.depth) {
            return new Pair(left.depth + 1, root);
        }
        if (left.depth > right.depth) {
            return new Pair(left.depth + 1, left.ans);
        }
        return new Pair(right.depth + 1, right.ans);
    }
}
