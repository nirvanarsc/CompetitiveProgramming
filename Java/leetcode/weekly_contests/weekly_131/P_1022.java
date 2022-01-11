package leetcode.weekly_contests.weekly_131;

import utils.DataStructures.TreeNode;

@SuppressWarnings("ConstantConditions")
public class P_1022 {

    static int res;

    public int sumRootToLeaf(TreeNode root) {
        res = 0;
        dfs(root, new int[1]);
        return res;
    }

    private static void dfs(TreeNode node, int[] path) {
        if (node == null) {
            return;
        }
        path[0] = path[0] << 1 | node.val;
        if (node.left == null && node.right == null) {
            res += path[0];
        }
        dfs(node.left, path);
        dfs(node.right, path);
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
