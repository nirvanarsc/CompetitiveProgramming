package hard;

import utils.DataStructures.TreeNode;

public class P_124 {

    public int maxPathSum(TreeNode root) {
        final int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
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
