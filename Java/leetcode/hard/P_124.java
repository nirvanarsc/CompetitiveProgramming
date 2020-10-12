package leetcode.hard;

import utils.DataStructures.TreeNode;

public class P_124 {

    public int maxPathSum(TreeNode root) {
        return recurse(root)[0];
    }

    private static int[] recurse(TreeNode root) {
        if (root == null) {
            return new int[] { 0, Integer.MIN_VALUE };
        }
        final int[] leftMax = recurse(root.left);
        final int[] rightMax = recurse(root.right);
        final int left = leftMax[0];
        final int right = rightMax[0];
        final int curr = root.val + Math.max(left, right);
        final int best = Math.max(Math.max(leftMax[1], rightMax[1]), root.val + left + right);
        return new int[] { curr, best };
    }

    public int maxPathSumSplit(TreeNode root) {
        final int[] max = { Integer.MIN_VALUE };
        maxPathSum(max, root);
        return max[0];
    }

    private static int maxPathSum(int[] max, TreeNode root) {
        if (root == null) {
            return 0;
        }
        final int leftMax = Math.max(0, maxPathSum(max, root.left));
        final int rightMax = Math.max(0, maxPathSum(max, root.right));
        max[0] = Math.max(max[0], root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}
