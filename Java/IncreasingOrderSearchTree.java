public class IncreasingOrderSearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    TreeNode res;
    TreeNode prev;

    public TreeNode increasingBST(TreeNode root) {
        traverseTree(root);
        return res;
    }

    void traverseTree(TreeNode root) {
        if (root != null) {
            traverseTree(root.left);
            if (res == null) {
                res = new TreeNode(root.val);
                prev = res;
            } else {
                final TreeNode curr = new TreeNode(root.val);
                prev.right = curr;
                prev = curr;
            }
            traverseTree(root.right);
        }
    }
}
