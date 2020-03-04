package weekly_contests.weekly_120;

import utils.DataStructures.TreeNode;

public class P_979 {

    public int distributeCoins(TreeNode root) {
        final int[] res = { 0 };
        dfs(root, res);
        return res[0];
    }

    private static int dfs(TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }
        final int left = dfs(node.left, res);
        final int right = dfs(node.right, res);
        res[0] += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1;
    }
}
