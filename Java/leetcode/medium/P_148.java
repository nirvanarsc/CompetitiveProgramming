package leetcode.medium;

import utils.DataStructures.ListNode;

public class P_148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode preSlow = new ListNode(0);
        preSlow.next = head;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            preSlow = preSlow.next;
        }
        preSlow.next = null; // Splits the list into two equal-sized lists.

        head = sortList(head);
        slow = sortList(slow);

        return mergeTwoSortedLists(head, slow);
    }

    public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        if (l1 == null) { return l2; }
        if (l2 == null) { return l1; }

        final ListNode head = new ListNode(0);
        ListNode curr = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;

        return head.next;
    }
}
