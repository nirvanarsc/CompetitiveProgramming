package medium;

import utils.DataStructures.ListNode;

public class P_369 {

    public ListNode plusOne(ListNode head) {
        final ListNode dummy = new ListNode(0);
        ListNode lastNot9 = dummy;
        dummy.next = head;
        for (ListNode n = head; n != null; n = n.next) {
            if (n.val != 9) {
                lastNot9 = n;
            }
        }
        lastNot9.val++;
        for (ListNode n = lastNot9.next; n != null; n = n.next) {
            n.val = 0;
        }
        return dummy.val == 1 ? dummy : head;
    }
}
