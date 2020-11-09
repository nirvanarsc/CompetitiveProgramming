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
        final int[] left = dfs(node.left);
        final int[] right = dfs(node.right);
        final int min = Math.min(left[0], right[0]);
        final int max = Math.max(left[1], right[1]);
        int res = Math.max(left[2], right[2]);
        if (min != (int) 1e9) {
            res = Math.max(res, Math.abs(node.val - min));
        }
        if (max != (int) -1e9) {
            res = Math.max(res, Math.abs(node.val - max));
        }
        return new int[] { Math.min(min, node.val), Math.max(max, node.val), res };
    }
}
