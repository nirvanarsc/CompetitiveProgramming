package leetcode.weekly_contests.weekly_200_299.weekly_281;

import utils.DataStructures.ListNode;

public class P_2 {

    public ListNode mergeNodes(ListNode head) {
        final ListNode res = new ListNode(-1);
        ListNode resIter = res;
        for (ListNode iter = head; iter != null; ) {
            if (iter.val == 0) {
                ListNode next = iter.next;
                int sum = 0;
                while (next != null && next.val != 0) {
                    sum += next.val;
                    next = next.next;
                }
                if (sum > 0) {
                    resIter.next = new ListNode(sum);
                    resIter = resIter.next;
                }
                iter = next;
            }
        }
        return res.next;
    }
}
