public class UnivaluedBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public boolean isUnivalTree(TreeNode root) {
        return isNodeUnival(root, root.val);
    }

    public boolean isNodeUnival(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        return node.val == val && isNodeUnival(node.left, val) && isNodeUnival(node.right, val);
    }
}
