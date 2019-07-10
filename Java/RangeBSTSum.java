public class RangeBSTSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (L <= root.val && root.val <= R) {
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else return rangeSumBST(root.left, L, R);
    }
}
