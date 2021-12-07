package leetcode.weekly_contests.weekly_270;

import utils.DataStructures.ListNode;

@SuppressWarnings({ "ReturnOfNull", "ConstantConditions" })
public class P_2 {

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        final ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
