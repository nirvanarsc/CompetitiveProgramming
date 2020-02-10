package easy;

import utils.DataStructures.TreeNode;

public class P_270 {

    public int closestValueIterative(TreeNode root, double target) {
        int ret = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - ret)) {
                ret = root.val;
                if (Math.abs(target - root.val) <= 0.5) {
                    break;
                }
            }
            root = root.val > target ? root.left : root.right;
        }
        return ret;
    }

    public int closestValue(TreeNode root, double target) {
        final int[] res = { Integer.MAX_VALUE };
        final double[] diff = { Double.MAX_VALUE };
        recurse(root, target, res, diff);
        return res[0];
    }

    private static void recurse(TreeNode node, double target, int[] res, double[] diff) {
        if (node == null) {
            return;
        }
        final double currDiff = Math.abs(node.val - target);
        if (currDiff < diff[0]) {
            res[0] = node.val;
            diff[0] = currDiff;
        }
        if (node.val < target) {
            recurse(node.right, target, res, diff);
        } else {
            recurse(node.left, target, res, diff);
        }
    }
}
