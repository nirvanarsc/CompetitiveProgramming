package leetcode.weekly_contests.weekly_124;

import utils.DataStructures.TreeNode;

public class P_993 {

    static int[] d, p;
    static int l, r;

    public boolean isCousins(TreeNode root, int x, int y) {
        l = x;
        r = y;
        d = new int[101];
        p = new int[101];
        dfs(root, new TreeNode(0));
        return d[x] == d[y] && p[x] != p[y];
    }

    private static void dfs(TreeNode curr, TreeNode par) {
        if (curr == null) {
            return;
        }
        d[curr.val] = d[par.val] + 1;
        p[curr.val] = par.val;
        dfs(curr.left, curr);
        dfs(curr.right, curr);
    }
}
