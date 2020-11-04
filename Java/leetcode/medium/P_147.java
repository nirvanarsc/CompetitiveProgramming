package leetcode.medium;

import utils.DataStructures.ListNode;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
public class P_147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        final ListNode res = new ListNode(-1);
        ListNode rem = head.next;
        head.next = null;
        res.next = head;
        while (rem != null) {
            final ListNode next = rem.next;
            rem.next = null;
            insert(res, rem);
            rem = next;
        }
        return res.next;
    }

    private static void insert(ListNode res, ListNode node) {
        ListNode prev = res;
        ListNode iter = res.next;
        while (iter != null && iter.val < node.val) {
            prev = prev.next;
            iter = iter.next;
        }
        final ListNode temp = prev.next;
        prev.next = node;
        node.next = temp;
    }
}
