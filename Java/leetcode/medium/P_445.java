package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.DataStructures.ListNode;

@SuppressWarnings("ConstantConditions")
public class P_445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final Deque<Integer> s1 = new ArrayDeque<>();
        final Deque<Integer> s2 = new ArrayDeque<>();
        while (l1 != null) {
            s1.addFirst(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.addFirst(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode list = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int num = carry;
            if (!s1.isEmpty()) { num += s1.removeFirst(); }
            if (!s2.isEmpty()) { num += s2.removeFirst(); }
            carry = num / 10;
            final ListNode head = new ListNode(num % 10);
            head.next = list;
            list = head;
        }
        if (carry > 0) {
            final ListNode head = new ListNode(carry);
            head.next = list;
            list = head;
        }
        return list;
    }
}
