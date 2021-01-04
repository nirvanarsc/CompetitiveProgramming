package leetcode.easy;

import utils.DataStructures.ListNode;

public class P_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        final ListNode res = new ListNode(-1);
        ListNode iter = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                iter.next = l1;
                l1 = l1.next;
            } else {
                iter.next = l2;
                l2 = l2.next;
            }
            iter = iter.next;
        }
        iter.next = l1 != null ? l1 : l2;
        return res.next;
    }
}
