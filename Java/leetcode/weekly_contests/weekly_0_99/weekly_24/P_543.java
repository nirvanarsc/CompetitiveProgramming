package leetcode.weekly_contests.weekly_0_99.weekly_24;

import utils.DataStructures.TreeNode;

public class P_543 {

    static int res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    private static int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }
        final int[] l = dfs(node.left);
        final int[] r = dfs(node.right);
        for (int n1 : l) {
            for (int n2 : r) {
                res = Math.max(res, n1 + n2);
            }
        }
        return new int[] { Math.max(l[0], l[1]) + 1, Math.max(r[0], r[1]) + 1 };
    }
}
