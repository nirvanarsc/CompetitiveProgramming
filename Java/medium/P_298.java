package medium;

import utils.DataStructures.TreeNode;

public class P_298 {

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, Integer.MAX_VALUE)[0];
    }

    private static int[] dfs(TreeNode node, int parent) {
        if (node == null) {
            return new int[] { 1, 1 };
        }
        final int[] left = dfs(node.left, node.val);
        final int[] right = dfs(node.right, node.val);
        int curr = 1;
        if (node.val - 1 == parent) {
            curr = Math.max(left[1], right[1]) + 1;
        }
        return new int[] { Math.max(curr, Math.max(left[0], right[0])), curr };
    }
}
