package leetcode.weekly_contests.weekly_0_99.weekly_35;

import utils.DataStructures.TreeNode;

public class P_606 {

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right != null) {
            return String.format("%d()(%s)", t.val, tree2str(t.right));
        }
        if (t.left != null && t.right == null) {
            return String.format("%d(%s)", t.val, tree2str(t.left));
        }
        if (t.left == t.right) {
            return String.valueOf(t.val);
        }
        return String.format("%d(%s)(%s)", t.val, tree2str(t.left), tree2str(t.right));
    }
}
