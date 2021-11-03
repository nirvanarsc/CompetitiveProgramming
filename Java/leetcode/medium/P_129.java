package leetcode.medium;

import utils.DataStructures.TreeNode;

public class P_129 {

    static int total;
    static int curr;

    public int sumNumbers(TreeNode root) {
        total = 0;
        curr = 0;
        dfs(root);
        return total;
    }

    private static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        curr *= 10;
        curr += node.val;
        if (node.left == null && node.right == null) {
            total += curr;
        }
        //noinspection ConstantConditions
        dfs(node.left);
        dfs(node.right);
        curr /= 10;
    }
}
