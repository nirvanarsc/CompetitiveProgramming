package leetcode.medium;

import utils.DataStructures.ListNode;

public class P_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final ListNode res = new ListNode(-1);
        ListNode iter = res;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int next = carry;
            if (l1 != null) { next += l1.val; }
            if (l2 != null) { next += l2.val; }
            carry = next / 10;
            iter.next = new ListNode(next % 10);
            if (l1 != null) { l1 = l1.next; }
            if (l2 != null) { l2 = l2.next; }
            iter = iter.next;
        }
        if (carry > 0) {
            iter.next = new ListNode(carry);
        }
        return res.next;
    }
}
