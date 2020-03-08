package biweekly_contests.biweekly_21;

import utils.DataStructures.TreeNode;

public class P_1372 {

    public int longestZigZagFlag(TreeNode root) {
        final int[] res = { 0 };
        dfs(root, true, res);
        return res[0];
    }

    private static int dfs(TreeNode node, boolean right, int[] res) {
        if (node == null) {
            return 0;
        }
        final int l = dfs(node.left, true, res);
        final int r = dfs(node.right, false, res);
        res[0] = Math.max(res[0], Math.max(l, r));
        return 1 + (right ? r : l);
    }

    public int longestZigZag(TreeNode root) {
        return dfs(root)[2];
    }

    private static int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] { -1, -1, -1 };
        }
        final int[] left = dfs(root.left);
        final int[] right = dfs(root.right);
        final int res = Math.max(Math.max(left[1], right[0]) + 1, Math.max(left[2], right[2]));
        return new int[] { left[1] + 1, right[0] + 1, res };
    }
}
