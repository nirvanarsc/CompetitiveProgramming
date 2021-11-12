package leetcode.easy;

import utils.DataStructures.ListNode;

@SuppressWarnings("ConstantConditions")
public class P_203 {

    public ListNode removeElements(ListNode head, int val) {
        final ListNode dummy = new ListNode(-1);
        ListNode iter = dummy;
        while (head != null) {
            if (head.val != val) {
                iter.next = head;
                iter = iter.next;
            }
            head = head.next;
        }
        iter.next = null;
        return dummy.next;
    }
}
