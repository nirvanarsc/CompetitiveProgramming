package leetcode.medium;

import utils.DataStructures.ListNode;

@SuppressWarnings({ "ConstantConditions", "TailRecursion" })
public class P_92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode iter1 = new ListNode(-1);
        final ListNode res = iter1;
        iter1.next = head;
        for (int i = 0; i < left - 1; i++) {
            iter1 = iter1.next;
        }
        ListNode iter2 = iter1;
        for (int i = 0; i < right - left + 1; i++) {
            iter2 = iter2.next;
        }
        final ListNode after = iter2.next;
        // cut
        iter2.next = null;
        final ListNode revStart = iter1.next;
        iter1.next = reverse(revStart, null);
        revStart.next = after;
        return res.next;
    }

    private static ListNode reverse(ListNode curr, ListNode tail) {
        if (curr == null) {
            return tail;
        }
        final ListNode next = curr.next;
        curr.next = tail;
        return reverse(next, curr);
    }
}
