package weekly_contests.weekly_135;

import utils.DataStructures.TreeNode;

public class P_1038 {

    public TreeNode bstToGst(TreeNode root) {
        recurse(root, new int[] { 0 });
        return root;
    }

    private static void recurse(TreeNode node, int[] sum) {
        if (node == null) {
            return;
        }
        recurse(node.right, sum);
        sum[0] = node.val += sum[0];
        recurse(node.left, sum);
    }
}
