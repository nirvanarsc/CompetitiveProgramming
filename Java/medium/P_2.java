package medium;

import utils.DataStructures.ListNode;

public class P_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        final ListNode dummy = new ListNode(-1);
        ListNode iter = dummy;
        while (l1 != null && l2 != null) {
            l1.val += l2.val + carry;
            carry = 0;
            if (l1.val > 9) {
                carry = 1;
                l1.val -= 10;
            }
            iter.next = l1;
            l1 = l1.next;
            l2 = l2.next;
            iter = iter.next;
        }
        ListNode remainder = l1 != null ? l1 : l2;
        while (remainder != null) {
            iter.next = remainder;
            remainder.val += carry;
            carry = 0;
            if (remainder.val > 9) {
                carry = 1;
                remainder.val -= 10;
            }
            remainder = remainder.next;
            iter = iter.next;
        }
        if (carry > 0) {
            iter.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
