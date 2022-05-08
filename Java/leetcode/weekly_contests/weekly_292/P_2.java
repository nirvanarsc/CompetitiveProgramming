package leetcode.weekly_contests.weekly_292;

import utils.DataStructures.TreeNode;

public class P_2 {

    static int res;

    public int averageOfSubtree(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    private static int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        final int[] l = dfs(node.left);
        final int[] r = dfs(node.right);
        final int[] next = { l[0] + r[0] + node.val, l[1] + r[1] + 1 };
        if (node.val == next[0] / next[1]) {
            res++;
        }
        return next;
    }
}
