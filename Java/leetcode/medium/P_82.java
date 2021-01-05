package leetcode.medium;

import utils.DataStructures.ListNode;

@SuppressWarnings("ConstantConditions")
public class P_82 {

    public ListNode deleteDuplicates(ListNode head) {
        final ListNode res = new ListNode((int) -1e9);
        ListNode prev = res;
        ListNode curr = head;
        while (curr != null) {
            int count = 0;
            final ListNode now = curr;
            while (curr != null && curr.val == now.val) {
                curr = curr.next;
                count++;
            }
            if (count == 1) {
                prev.next = now;
                prev = prev.next;
            }
        }
        prev.next = null;
        return res.next;
    }
}
