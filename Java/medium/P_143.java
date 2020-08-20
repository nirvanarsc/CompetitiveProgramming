package medium;

import utils.DataStructures.ListNode;

@SuppressWarnings({ "TailRecursion", "ConstantConditions" })
public class P_143 {

    public void reorderList(ListNode head) {
        final ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode upper = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode lower = slow.next;
        slow.next = null;
        lower = reverse(lower, null);
        while (lower != null) {
            final ListNode t1 = upper.next;
            final ListNode t2 = lower.next;
            upper.next = lower;
            lower.next = t1;
            upper = t1;
            lower = t2;
        }
    }

    private static ListNode reverse(ListNode head, ListNode newTail) {
        if (head == null) {
            return newTail;
        }
        final ListNode next = head.next;
        head.next = newTail;
        return reverse(next, head);
    }
}
