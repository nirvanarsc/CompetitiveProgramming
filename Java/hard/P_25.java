package hard;

import utils.DataStructures.ListNode;

public class P_25 {

    @SuppressWarnings("ConstantConditions")
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode test = head;
        for (int i = 1; i < k && test != null; i++) {
            test = test.next;
        }
        if (test == null) {
            return head;
        }
        ListNode iter = head;
        ListNode newHead = null;
        for (int i = 0; i < k; i++) {
            final ListNode temp = iter.next;
            iter.next = newHead;
            newHead = iter;
            iter = temp;
        }
        head.next = reverseKGroup(iter, k);
        return newHead;
    }
}
