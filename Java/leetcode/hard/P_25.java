package leetcode.hard;

import utils.DataStructures.ListNode;

public class P_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        final ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode iter = dummy;
        for (int i = 0; i < k && iter != null; i++) {
            iter = iter.next;
        }
        if (iter == null) {
            return head;
        }
        final ListNode next = iter.next;
        //noinspection ConstantConditions
        iter.next = null;
        final ListNode rev = reverse(head, null);
        head.next = reverseKGroup(next, k);
        return rev;
    }

    private static ListNode reverse(ListNode curr, ListNode newHead) {
        if (curr == null) {
            return newHead;
        }
        final ListNode temp = curr.next;
        curr.next = newHead;
        //noinspection TailRecursion
        return reverse(temp, curr);
    }
}
