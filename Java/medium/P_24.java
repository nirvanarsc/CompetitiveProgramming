package medium;

import utils.DataStructures.ListNode;

public class P_24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        final ListNode second = head.next;
        final ListNode third = head.next.next;

        second.next = head;
        head.next = swapPairs(third);

        return second;
    }
}
