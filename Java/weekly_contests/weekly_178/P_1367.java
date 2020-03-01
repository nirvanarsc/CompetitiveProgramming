package weekly_contests.weekly_178;

import utils.DataStructures.ListNode;
import utils.DataStructures.TreeNode;

public class P_1367 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return match(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private static boolean match(ListNode head, TreeNode node) {
        if (head == null) {
            return true;
        }
        if (node == null) {
            return false;
        }
        return head.val == node.val && (match(head.next, node.left) || match(head.next, node.right));
    }
}
