public class RangeBSTSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static int rangeSumBST(TreeNode root, int L, int R) {
        while (true) {
            if (root == null) {
                return 0;
            }
            if (L <= root.val && root.val <= R) {
                return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
            }
            if (root.val < L) {
                root = root.right;
            } else {root = root.left;}
        }
    }
}
