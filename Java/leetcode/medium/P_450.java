package leetcode.medium;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
public class P_450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            } else {
                TreeNode iter = root.right;
                while (iter.left != null) {
                    iter = iter.left;
                }
                root.val = iter.val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }
}
