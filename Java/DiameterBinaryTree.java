public class DiameterBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        return dfs(root)[0];
    }

    public int diameterOfBinaryTree2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + maxDepth(root.right),
                        Math.max(diameterOfBinaryTree(root.right),
                                 diameterOfBinaryTree(root.left)));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
