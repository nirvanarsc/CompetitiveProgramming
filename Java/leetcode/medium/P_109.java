package leetcode.medium;

import utils.DataStructures.ListNode;
import utils.DataStructures.TreeNode;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
public class P_109 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        final ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        final ListNode right = slow.next.next;
        final ListNode root = slow.next;
        slow.next.next = null;
        slow.next = null;
        return new TreeNode(root.val, sortedListToBST(dummy.next), sortedListToBST(right));
    }
}
