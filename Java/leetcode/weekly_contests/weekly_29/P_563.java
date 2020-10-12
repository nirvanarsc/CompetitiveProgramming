package leetcode.weekly_contests.weekly_29;

import utils.DataStructures.TreeNode;

public class P_563 {

    public int findTilt(TreeNode root) {
        return recurse(root)[0];
    }

    private static int[] recurse(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }
        final int[] left = recurse(node.left);
        final int[] right = recurse(node.right);
        final int diff = left[0] + right[0] + Math.abs(left[1] - right[1]);
        final int sum = left[1] + right[1] + node.val;
        return new int[] { diff, sum };
    }
}
