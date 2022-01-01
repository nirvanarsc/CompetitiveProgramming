package leetcode.weekly_contests.weekly_132;

import utils.DataStructures.TreeNode;

public class P_1026 {

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root)[2];
    }

    private static int[] dfs(TreeNode node) {
        final int[] res = { (int) 1e9, (int) -1e9, 0 };
        if (node == null) {
            return res;
        }
        final int[] l = dfs(node.left);
        final int[] r = dfs(node.right);
        res[0] = Math.min(res[0], l[0]);
        res[0] = Math.min(res[0], r[0]);
        res[0] = Math.min(res[0], node.val);
        res[1] = Math.max(res[1], l[1]);
        res[1] = Math.max(res[1], r[1]);
        res[1] = Math.max(res[1], node.val);
        res[2] = Math.max(res[2], l[2]);
        res[2] = Math.max(res[2], r[2]);
        res[2] = Math.max(res[2], node.val - res[0]);
        res[2] = Math.max(res[2], res[1] - node.val);
        return res;
    }
}
