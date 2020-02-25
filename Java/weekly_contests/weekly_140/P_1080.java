package weekly_contests.weekly_140;

import utils.DataStructures.TreeNode;

public class P_1080 {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return limit <= root.val ? root : null;
        }

        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right, limit - root.val);

        return (root.left == root.right) ? null : root;
    }
}
