package medium;

import utils.DataStructures.TreeNode;

public class P_129 {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    int dfs(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }

        return dfs(node.left, sum) + dfs(node.right, sum);
    }
}
