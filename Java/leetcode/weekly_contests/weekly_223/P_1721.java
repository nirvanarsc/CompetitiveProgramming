package leetcode.weekly_contests.weekly_223;

import utils.DataStructures.ListNode;

@SuppressWarnings("ConstantConditions")
public class P_1721 {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode iter = new ListNode(-1);
        iter.next = head;
        for (int i = 0; i < k; i++) {
            iter = iter.next;
        }
        final ListNode first = iter;
        ListNode iter2 = new ListNode(-1);
        iter2.next = head;
        while (iter != null) {
            iter = iter.next;
            iter2 = iter2.next;
        }
        final int temp = first.val;
        first.val = iter2.val;
        iter2.val = temp;
        return head;
    }
}
