package leetcode.weekly_contests.weekly_100_199.weekly_125;

import utils.DataStructures.TreeNode;

public class P_998 {

    @SuppressWarnings("ConstantConditions")
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root != null && root.val > val) {
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
        final TreeNode node = new TreeNode(val);
        node.left = root;
        return node;
    }
}
