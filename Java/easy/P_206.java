package easy;

import utils.DataStructures.ListNode;

public class P_206 {

    // Iterative
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            final ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }

    // Recursive
    public ListNode reverseListR(ListNode head) {
        return reverseListR(head, null);
    }

    private static ListNode reverseListR(ListNode head, ListNode newHead) {
        if (head == null) { return newHead; }
        final ListNode next = head.next;
        head.next = newHead;
        return reverseListR(next, head);
    }
}
