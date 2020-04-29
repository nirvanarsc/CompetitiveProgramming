package weekly_contests.weekly_35;

import utils.DataStructures.TreeNode;

public class P_606 {

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        if (t.left == null && t.right != null) {
            sb.append("()(" + tree2str(t.right) + ')');
        } else if (t.left != null && t.right == null) {
            sb.append('(' + tree2str(t.left) + ')');
        } else if (t.left != null) {
            sb.append('(' + tree2str(t.left) + ')');
            sb.append('(' + tree2str(t.right) + ')');
        }
        return sb.toString();
    }
}
