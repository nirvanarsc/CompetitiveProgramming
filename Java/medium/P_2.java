package medium;

import utils.DataStructures.ListNode;

public class P_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final ListNode head = new ListNode(-1);
        ListNode iter = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            final int next = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            iter.next = new ListNode(next % 10);
            iter = iter.next;
            carry = next / 10;
            if (l1 != null) { l1 = l1.next; }
            if (l2 != null) { l2 = l2.next; }
        }
        if (carry > 0) {
            iter.next = new ListNode(carry);
        }
        return head.next;
    }
}
