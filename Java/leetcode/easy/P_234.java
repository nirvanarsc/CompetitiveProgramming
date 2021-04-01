package leetcode.easy;

import utils.DataStructures.ListNode;

@SuppressWarnings({ "ConstantConditions", "TailRecursion" })
public class P_234 {

    public boolean isPalindrome(ListNode head) {
        final ListNode dummy = new ListNode(-1);
        dummy.next = head;
        final ListNode mid = findMiddle(dummy);
        final ListNode t = mid.next;
        mid.next = null;
        ListNode rev = reverse(t, null);
        while (rev != null) {
            if (head.val != rev.val) {
                return false;
            }
            rev = rev.next;
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

    private static ListNode reverse(ListNode node, ListNode tail) {
        if (node == null) {
            return tail;
        }
        final ListNode next = node.next;
        node.next = tail;
        return reverse(next, node);
    }
}
