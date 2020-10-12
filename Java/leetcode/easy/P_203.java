package leetcode.easy;

import utils.DataStructures.ListNode;

public class P_203 {

    @SuppressWarnings("ConstantConditions")
    public ListNode removeElements(ListNode head, int val) {
        final ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (ListNode iter = dummy; iter != null && iter.next != null; iter = iter.next) {
            ListNode next = iter;
            while (next.next != null && next.next.val == val) {
                next = next.next;
            }
            iter.next = next.next;
        }
        return dummy.next;
    }
}
