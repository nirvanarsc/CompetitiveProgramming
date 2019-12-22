package medium;

import utils.DataStructures.ListNode;

public class P_147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        final ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode pre = dummy;
        ListNode next;
        while (cur != null) {
            next = cur.next;

            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }

            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = next;
        }

        return dummy.next;
    }

}
