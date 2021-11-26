package leetcode.weekly_contests.weekly_267;

import utils.DataStructures.ListNode;

@SuppressWarnings("ConstantConditions")
public class P_2 {

    public ListNode reverseEvenLengthGroups(ListNode head) {
        int n = 0;
        ListNode iter = head;
        while (iter != null) {
            n++;
            iter = iter.next;
        }
        iter = new ListNode(-1);
        iter.next = head;
        for (int turn = 1; n > 0; turn++) {
            final int curr = Math.min(turn, n);
            n -= curr;
            if (curr % 2 == 0) {
                ListNode end = iter;
                for (int i = 0; i < curr; i++) {
                    end = end.next;
                }
                final ListNode temp = iter.next;
                final ListNode rem = end.next;
                iter.next = null;
                end.next = null;
                iter.next = reverse(temp);
                temp.next = rem;
                iter = temp;
            } else {
                for (int i = 0; i < curr; i++) {
                    iter = iter.next;
                }
            }
        }
        return head;
    }

    public ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            final ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
