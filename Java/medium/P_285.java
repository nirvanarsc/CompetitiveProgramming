package medium;

import utils.DataStructures.TreeNode;

public class P_285 {

    @SuppressWarnings("ConstantConditions")
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode candidate = null;
        TreeNode cur = root;

        while (cur != null) {
            if (cur.val > p.val) {
                candidate = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        return candidate;
    }
}
