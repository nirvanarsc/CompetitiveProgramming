package leetcode.medium;

import utils.DataStructures.ListNode;

public class P_24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        final ListNode s = head.next;
        final ListNode rem = head.next.next;
        s.next = head;
        head.next = swapPairs(rem);
        return s;
    }
}
