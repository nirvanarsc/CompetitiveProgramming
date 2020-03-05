package weekly_contests.weekly_117;

import utils.DataStructures.TreeNode;

public class P_965 {

    public boolean isUnivalTree(TreeNode root) {
        return dfs(root, root.val);
    }

    private static boolean dfs(TreeNode node, int n) {
        if (node == null) {
            return true;
        }

        return node.val == n && dfs(node.left, n) && dfs(node.right, n);
    }
}
