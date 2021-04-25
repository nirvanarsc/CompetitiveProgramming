package binarysearch.weekly_56;

public class P_4 {

    private static class Tree {
        int val;
        Tree left;
        Tree right;
    }

    static int res;

    public int solve(Tree root) {
        res = 0;
        dfs(null, root, null, 1);
        return res;
    }

    private static void dfs(Tree parent, Tree curr, Integer diff, int len) {
        res = Math.max(res, len);
        if (curr == null) {
            return;
        }
        if (parent != null) {
            if (diff != null && parent.val - curr.val == diff) {
                dfs(curr, curr.left, parent.val - curr.val, len + 1);
                dfs(curr, curr.right, parent.val - curr.val, len + 1);
            } else {
                dfs(curr, curr.left, parent.val - curr.val, 2);
                dfs(curr, curr.right, parent.val - curr.val, 2);
            }
        } else {
            dfs(curr, curr.left, null, len);
            dfs(curr, curr.right, null, len);
        }
    }
}
