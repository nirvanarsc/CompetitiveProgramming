package leetcode.weekly_contests.weekly_0_99.weekly_95;

import utils.DataStructures.ListNode;

@SuppressWarnings("ConstantConditions")
public class P_876 {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
