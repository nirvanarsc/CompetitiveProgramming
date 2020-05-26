package medium;

import utils.DataStructures.ListNode;

public class P_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        final ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        ListNode iter1 = sentinel;
        ListNode iter2 = sentinel;
        for (int i = 0; i <= n; i++) {
            iter1 = iter1.next;
        }
        while (iter1 != null) {
            iter1 = iter1.next;
            iter2 = iter2.next;
        }

        iter2.next = iter2.next.next;
        return sentinel.next;
    }
}
