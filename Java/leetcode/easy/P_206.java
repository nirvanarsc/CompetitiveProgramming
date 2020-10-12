package leetcode.easy;

import utils.DataStructures.ListNode;

@SuppressWarnings({ "ConstantConditions", "TailRecursion" })
public class P_206 {

    // Iterative
    public ListNode reverseListIterative(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            final ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }

    // Recursive
    public ListNode reverseList(ListNode list) {
        return reverse(list, null);
    }

    private static ListNode reverse(ListNode list, ListNode newHead) {
        if (list == null) {
            return newHead;
        }
        final ListNode next = list.next;
        list.next = newHead;
        return reverse(next, list);
    }
}
