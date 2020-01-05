package medium;

import utils.DataStructures.TreeNode;

public class P_222 {

    private static int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }

    public int countNodes(TreeNode root) {
        final int h = height(root);
        return h < 0 ? 0 :
               height(root.right) == h - 1 ? (1 << h) + countNodes(root.right)
                                           : (1 << h - 1) + countNodes(root.left);
    }
}
