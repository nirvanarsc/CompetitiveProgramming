package leetcode.biweekly_contests.biweekly_17;

import utils.DataStructures.TreeNode;

public class P_1315 {

    public int sumEvenGrandparent(TreeNode root) {
        int curr = 0;
        if (root.val % 2 == 0) {
            if (root.left != null) {
                curr += root.left.left == null ? 0 : root.left.left.val;
                curr += root.left.right == null ? 0 : root.left.right.val;
            }
            if (root.right != null) {
                curr += root.right.left == null ? 0 : root.right.left.val;
                curr += root.right.right == null ? 0 : root.right.right.val;
            }
        }
        final int leftTree = root.left != null ? sumEvenGrandparent(root.left) : 0;
        final int rightTree = root.right != null ? sumEvenGrandparent(root.right) : 0;
        return curr + leftTree + rightTree;
    }
}
