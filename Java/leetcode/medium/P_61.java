package leetcode.medium;

import utils.DataStructures.ListNode;

@SuppressWarnings("ConstantConditions")
public class P_61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        ListNode iter = new ListNode(-1);
        iter.next = head;
        int length = 0;
        while (iter.next != null) {
            iter = iter.next;
            length++;
        }
        iter.next = head;
        k = length - k % length;
        for (int i = 0; i < k; i++) {
            iter = iter.next;
        }
        final ListNode newHead = iter.next;
        iter.next = null;
        return newHead;
    }
}
