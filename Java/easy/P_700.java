package easy;

import utils.DataStructures.TreeNode;

@SuppressWarnings("ConstantConditions")
public class P_700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
