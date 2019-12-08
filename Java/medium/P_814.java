package medium;

import utils.DataStructures.TreeNode;

public class P_814 {

    public TreeNode pruneTree(TreeNode root) {
        if (root.left != null) {
            root.left = pruneTree(root.left);
        }
        if (root.right != null) {
            root.right = pruneTree(root.right);
        }
        if (root.right == null && root.left == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
