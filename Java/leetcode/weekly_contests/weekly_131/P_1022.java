package leetcode.weekly_contests.weekly_131;

import utils.DataStructures.TreeNode;

@SuppressWarnings("ConstantConditions")
public class P_1022 {

    public int sumRootToLeaf(TreeNode root) {
        final int[] path = { 0 };
        final int[] res = { 0 };
        dfs(root, path, res);
        return res[0];
    }

    private static void dfs(TreeNode node, int[] path, int[] res) {
        if (node == null) {
            return;
        }
        path[0] = path[0] << 1 | node.val;
        dfs(node.left, path, res);
        if (node.left == null && node.right == null) {
            res[0] += path[0];
        }
        dfs(node.right, path, res);
        path[0] >>= 1;
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
