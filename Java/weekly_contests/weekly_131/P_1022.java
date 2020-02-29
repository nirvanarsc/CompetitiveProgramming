package weekly_contests.weekly_131;

import utils.DataStructures.TreeNode;

public class P_1022 {

    public int sumRootToLeaf(TreeNode root) {
        final int[] res = { 0 };
        recurse(root, res, 0);
        return res[0];
    }

    private static void recurse(TreeNode root, int[] sum, int curr) {
        if (root == null) {
            return;
        }
        curr = (curr << 1) | root.val;
        recurse(root.left, sum, curr);
        curr >>= 1;
        if (root.left == root.right) {
            sum[0] += (curr << 1) | root.val;
        }
        curr = (curr << 1) | root.val;
        recurse(root.right, sum, curr);
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
