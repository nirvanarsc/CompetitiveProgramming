package medium;

import utils.DataStructures.ListNode;

public class P_92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        final ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode iter = dummy;

        int k = 1;
        while (k++ < m) {
            iter = iter.next;
        }

        final ListNode newTail = iter.next;
        ListNode newIter = iter.next, newHead = null;

        while (m++ <= n) {
            final ListNode next = newIter.next;
            newIter.next = newHead;
            newHead = newIter;
            newIter = next;
        }

        newTail.next = newIter;
        iter.next = newHead;

        return dummy.next;
    }
}
