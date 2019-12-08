package medium;

import utils.DataStructures.TreeNode;

public class P_701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode iter = root;
        while (true) {
            if (iter.val > val) {
                if (iter.left != null) {
                    iter = iter.left;
                } else {
                    iter.left = new TreeNode(val);
                    break;
                }
            } else {
                if (iter.right != null) {
                    iter = iter.right;
                } else {
                    iter.right = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

    public TreeNode insertIntoBSTR(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insertIntoBSTR(root.right, val);
        } else {
            root.left = insertIntoBSTR(root.left, val);
        }
        return root;
    }
}
