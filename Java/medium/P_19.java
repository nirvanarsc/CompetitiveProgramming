package medium;

import utils.DataStructures.ListNode;

public class P_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        final ListNode start = new ListNode(0);
        start.next = head;

        ListNode slow = start;
        ListNode fast = start;
        while (n-- > 0) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return start.next;
    }
}
