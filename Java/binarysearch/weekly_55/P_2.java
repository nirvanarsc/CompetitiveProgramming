package binarysearch.weekly_55;

public class P_2 {

    private static class Tree {
        int val;
        Tree left;
        Tree right;
    }

    int res;

    public int solve(Tree root) {
        dfs(root);
        return res;
    }

    private int dfs(Tree root) {
        if (root == null) {
            return 0;
        }
        final int ll = dfs(root.left);
        final int rr = dfs(root.right);
        final int curr = root.val + ll + rr;
        res = Math.max(res, curr);
        return curr;
    }
}
