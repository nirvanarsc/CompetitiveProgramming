package medium;

import utils.DataStructures.TreeNode;

public class P_450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null || (root.left == null && root.right == null && root.val == key)) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }

        //Two children
        if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        } else {
            final TreeNode smallest = deleteSmallest(root.right);
            smallest.left = root.left;
            smallest.right = root.right;
            return smallest;
        }
    }

    private static TreeNode deleteSmallest(TreeNode root) {
        TreeNode curr = root.left;
        TreeNode pre = root;
        while (curr.left != null) {
            pre = curr;
            curr = curr.left;
        }
        pre.left = curr.right;
        return curr;
    }
}
