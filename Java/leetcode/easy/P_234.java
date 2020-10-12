package leetcode.easy;

import utils.DataStructures.ListNode;

@SuppressWarnings({ "ConstantConditions", "TailRecursion" })
public class P_234 {

    public boolean isPalindrome(ListNode head) {
        ListNode reverse = reverse(findMiddle(head), null);
        while (reverse != null) {
            if (head.val != reverse.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
