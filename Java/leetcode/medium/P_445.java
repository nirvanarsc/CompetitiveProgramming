package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.DataStructures.ListNode;

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

        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) { sum += s1.removeFirst(); }
            if (!s2.isEmpty()) { sum += s2.removeFirst(); }
            list.val = sum % 10;
            final ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }

        return list.val == 0 ? list.next : list;
    }
}
