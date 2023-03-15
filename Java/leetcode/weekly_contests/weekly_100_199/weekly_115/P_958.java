package leetcode.weekly_contests.weekly_100_199.weekly_115;

import utils.DataStructures.TreeNode;

public class P_958 {

    static int size;

    public boolean isCompleteTree(TreeNode root) {
        size = countNodes(root);
        return dfs(root, 1);
    }

    private static boolean dfs(TreeNode root, int curr) {
        if (root == null) {
            return true;
        }
        if (curr > size) {
            return false;
        }
        return dfs(root.left, 2 * curr) && dfs(root.right, 2 * curr + 1);
    }

    private static int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}
