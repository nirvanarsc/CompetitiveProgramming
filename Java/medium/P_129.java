package medium;

import utils.DataStructures.TreeNode;

public class P_129 {

    public int sumNumbers(TreeNode root) {
        final int[] res = { 0, 0 };
        dfs(root, res);
        return res[1];
    }

    @SuppressWarnings("ConstantConditions")
    private static void dfs(TreeNode root, int[] num) {
        if (root == null) {
            return;
        }
        num[0] = (num[0] * 10) + root.val;
        dfs(root.left, num);
        if (root.left == null && root.right == null) {
            num[1] += num[0];
        }
        dfs(root.right, num);
        num[0] /= 10;
    }
}
