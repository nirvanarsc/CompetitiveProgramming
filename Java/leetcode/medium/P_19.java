package leetcode.medium;

import utils.DataStructures.ListNode;

public class P_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        final ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode iter = head;
        for (int i = 0; i < n; i++) {
            iter = iter.next;
        }
        ListNode iter2 = dummy;
        while (iter != null) {
            iter = iter.next;
            iter2 = iter2.next;
        }
        //noinspection ConstantConditions
        iter2.next = iter2.next.next;
        return dummy.next;
    }
}
