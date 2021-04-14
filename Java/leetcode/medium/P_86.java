package leetcode.medium;

import utils.DataStructures.ListNode;

@SuppressWarnings("ConstantConditions")
public final class P_86 {

    public ListNode partition(ListNode head, int x) {
        final ListNode l1 = new ListNode(-1);
        final ListNode l2 = new ListNode(-1);
        ListNode iter1 = l1;
        ListNode iter2 = l2;
        while (head != null) {
            if (head.val < x) {
                iter1.next = head;
                iter1 = iter1.next;
            } else {
                iter2.next = head;
                iter2 = iter2.next;
            }
            head = head.next;
        }
        iter2.next = null;
        iter1.next = l2.next;
        return l1.next;
    }
}
