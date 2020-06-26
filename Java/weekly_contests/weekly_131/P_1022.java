package weekly_contests.weekly_131;

import utils.DataStructures.TreeNode;

public class P_1022 {

    public int sumRootToLeaf(TreeNode root) {
        final int[] res = { 0, 0 };
        dfs(root, res);
        return res[1];
    }

    @SuppressWarnings("ConstantConditions")
    private static void dfs(TreeNode root, int[] res) {
        if (root == null) {
            return;
        }
        res[0] = (res[0] << 1) | root.val;
        dfs(root.left, res);
        if (root.left == null && root.right == null) {
            res[1] += res[0];
        }
        dfs(root.right, res);
        res[0] >>= 1;
    }

    public int sumRootToLeafDFS(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = val << 1 | root.val;
        return root.left == root.right ? val : dfs(root.left, val) + dfs(root.right, val);
    }
}
