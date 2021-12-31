package leetcode.weekly_contests.weekly_132;

import utils.DataStructures.TreeNode;

public class P_1026 {

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root)[2];
    }

    private static int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] { (int) 1e9, (int) -1e9, 0 };
        }
        final int[] l = dfs(node.left);
        final int[] r = dfs(node.right);
        int min = (int) 1e9;
        int max = (int) -1e9;
        int res = 0;
        min = Math.min(min, l[0]);
        min = Math.min(min, r[0]);
        min = Math.min(min, node.val);
        max = Math.max(max, l[1]);
        max = Math.max(max, r[1]);
        max = Math.max(max, node.val);
        res = Math.max(res, l[2]);
        res = Math.max(res, r[2]);
        res = Math.max(res, node.val - min);
        res = Math.max(res, max - node.val);
        return new int[] { min, max, res };
    }
}
