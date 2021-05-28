package binarysearch.weekly_37;

public class P_1 {

    private static class Tree {
        int val;
        Tree left;
        Tree right;
    }

    static int l;
    static int r;

    public int solve(Tree root) {
        l = (int) 1e9;
        r = (int) -1e9;
        dfs(root, 0);
        return r - l + 1;
    }

    private static void dfs(Tree node, int d) {
        if (node == null) {
            return;
        }
        l = Math.min(l, d);
        r = Math.max(r, d);
        dfs(node.left, d - 1);
        dfs(node.right, d + 1);
    }
}
