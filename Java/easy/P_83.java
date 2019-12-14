package easy;

import utils.DataStructures.ListNode;

public class P_83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode iter = head;
        while (iter != null) {
            while (iter.next != null && iter.next.val == iter.val) {
                iter.next = iter.next.next;
            }
            iter = iter.next;
        }
        return head;
    }
}
