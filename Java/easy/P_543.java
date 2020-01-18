package easy;

import utils.DataStructures.TreeNode;

public class P_543 {

    public int diameterOfBinaryTreeSimplified(TreeNode root) {
        final int[] res = { 0 };
        maxDepth(root, res);
        return res[0];
    }

    public int maxDepth(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }

        final int L = maxDepth(root.left, res);
        final int R = maxDepth(root.right, res);
        res[0] = Math.max(res[0], L + R);
        return 1 + Math.max(L, R);
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        return dfs(root)[0];
    }

    private static int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }
        final int[] left = dfs(node.left);
        final int[] right = dfs(node.right);

        final int best = Math.max(left[1] + right[1], Math.max(left[0], right[0]));
        final int height = 1 + Math.max(left[1], right[1]);
        return new int[] { best, height };
    }
}
