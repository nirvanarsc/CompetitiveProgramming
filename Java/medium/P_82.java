package medium;

import utils.DataStructures.ListNode;

public class P_82 {

    public ListNode deleteDuplicates(ListNode head) {
        final ListNode sentinel = new ListNode(0);
        ListNode slow = sentinel;
        ListNode fast = head;
        slow.next = fast;

        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            if (slow.next != fast) {
                slow.next = fast.next;
                fast = slow.next;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }

        return sentinel.next;
    }
}
