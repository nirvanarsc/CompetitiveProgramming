package leetcode.weekly_contests.weekly_36;

import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
public class P_617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        final TreeNode res = new TreeNode(t1.val + t2.val);
        res.left = mergeTrees(t1.left, t2.left);
        res.right = mergeTrees(t2.right, t2.right);
        return res;
    }
}
