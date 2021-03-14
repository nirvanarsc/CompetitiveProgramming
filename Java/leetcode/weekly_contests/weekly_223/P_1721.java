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
        ListNode iter2 = iter;
        ListNode swap = new ListNode(-1);
        swap.next = head;
        while (iter2 != null) {
            iter2 = iter2.next;
            swap = swap.next;
        }
        final int t = swap.val;
        swap.val = iter.val;
        iter.val = t;
        return head;
    }
}
