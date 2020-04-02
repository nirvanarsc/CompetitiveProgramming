package weekly_contests.weekly_70;

import utils.DataStructures.TreeNode;

public class P_776 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) {
            return new TreeNode[] { null, null };
        }
        if (root.val > V) {
            final TreeNode[] subR = splitBST(root.left, V);
            root.left = subR[1];
            return new TreeNode[] { subR[0], root };
        } else {
            final TreeNode[] subR = splitBST(root.right, V);
            root.right = subR[0];
            return new TreeNode[] { root, subR[1] };
        }
    }
}
