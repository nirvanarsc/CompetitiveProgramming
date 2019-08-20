import org.jetbrains.annotations.Nullable;

public class TrimBST {

    private static class TreeNode {
        int val;
        @Nullable TreeNode left;
        @Nullable TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public @Nullable TreeNode trimBST(@Nullable TreeNode root, int l, int r) {
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
