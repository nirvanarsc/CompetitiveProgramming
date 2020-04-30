package weekly_contests.weekly_31;

import utils.DataStructures.TreeNode;

public class P_572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return match(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private static boolean match(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && match(s.left, t.left) && match(s.right, t.right);
    }
}
