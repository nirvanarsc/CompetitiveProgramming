import utils.DataStructures.TreeNode;

public class TrimBST {

    @SuppressWarnings({ "TailRecursion", "ReturnOfNull" })
    public TreeNode trimBST(TreeNode root, int l, int r) {
        if (root == null) {
            return null;
        }
        if (root.val < l) {
            return trimBST(root.right, l, r);
        }
        if (root.val > r) {
            return trimBST(root.left, l, r);
        }

        root.left = trimBST(root.left, l, r);
        root.right = trimBST(root.right, l, r);
        return root;
    }
}
