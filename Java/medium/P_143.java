package medium;

import utils.DataStructures.ListNode;

public class P_143 {

    public void reorderList(ListNode head) {
        final ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        final ListNode lower = slow.next;
        slow.next = null;
        ListNode head2 = reverse(lower, null);

        while (head != null && head2 != null) {
            final ListNode tmp1 = head.next;
            final ListNode tmp2 = head2.next;
            head2.next = head.next;
            head.next = head2;
            head = tmp1;
            head2 = tmp2;
        }
    }

    private static ListNode reverse(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }

        final ListNode next = head.next;
        head.next = newHead;
        return reverse(next, head);
    }
}
