package leetcode.medium;

import utils.DataStructures.ListNode;

@SuppressWarnings("ConstantConditions")
public class P_148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        final ListNode temp = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(temp));
    }

    private static ListNode merge(ListNode up, ListNode down) {
        final ListNode merge = new ListNode(-1);
        ListNode iter = merge;
        while (up != null && down != null) {
            if (up.val < down.val) {
                iter.next = up;
                up = up.next;
            } else {
                iter.next = down;
                down = down.next;
            }
            iter = iter.next;
        }
        iter.next = up != null ? up : down;
        return merge.next;
    }
}
