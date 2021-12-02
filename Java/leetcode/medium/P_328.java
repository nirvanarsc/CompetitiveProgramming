package leetcode.medium;

import utils.DataStructures.ListNode;

public class P_328 {

    public ListNode oddEvenList(ListNode head) {
        final ListNode odd = new ListNode(-1);
        final ListNode even = new ListNode(-1);
        ListNode oddIter = odd;
        ListNode evenIter = even;
        for (int i = 1; head != null; i++) {
            if (i % 2 != 0) {
                oddIter.next = head;
                oddIter = oddIter.next;
            } else {
                evenIter.next = head;
                evenIter = evenIter.next;
            }
            final ListNode temp = head.next;
            //noinspection ConstantConditions
            head.next = null;
            head = temp;
        }
        oddIter.next = even.next;
        return odd.next;
    }
}
