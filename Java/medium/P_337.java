package medium;

import java.util.HashMap;
import java.util.Map;

import utils.DataStructures.TreeNode;

public class P_337 {

    public int rob(TreeNode root) {
        return rob(root, new HashMap<>());
    }

    public int rob(TreeNode root, Map<TreeNode, Integer> dp) {
        if (root == null) {
            return 0;
        }

        if (dp.containsKey(root)) {
            return dp.get(root);
        }

        int left = 0;
        if (root.left != null) {
            left = rob(root.left.left, dp) + rob(root.left.right, dp);
        }
        int right = 0;
        if (root.right != null) {
            right = rob(root.right.left, dp) + rob(root.right.right, dp);
        }

        dp.put(root, Math.max(root.val + left + right, rob(root.left, dp) + rob(root.right, dp)));
        return dp.get(root);
    }

    public int robOptimized(TreeNode root) {
        final int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private static int[] robSub(TreeNode root) {
        if (root == null) { return new int[2]; }

        final int[] left = robSub(root.left);
        final int[] right = robSub(root.right);
        final int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
