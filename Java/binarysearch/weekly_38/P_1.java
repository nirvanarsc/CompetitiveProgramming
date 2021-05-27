package binarysearch.weekly_38;

public class P_1 {

    private static class Tree {
        int val;
        Tree left;
        Tree right;
    }

    static int res;

    public int solve(Tree root) {
        res = 0;
        dfs(root);
        return res;
    }

    private static int dfs(Tree node) {
        if (node == null) {
            return 0;
        }
        final int l = dfs(node.left);
        final int r = dfs(node.right);
        if (node.left != null && node.right != null && ((l % 2) ^ (r % 2)) == 1) {
            res++;
        }
        return l + r + node.val;
    }
}
