package leetcode.weekly_contests.weekly_400_499.weekly_406;

import utils.DataStructures.ListNode;

public class P_2 {

    public ListNode modifiedList(int[] nums, ListNode head) {
        final boolean[] seen = new boolean[(int) (1e5 + 5)];
        for (int num : nums) {
            seen[num] = true;
        }
        final ListNode res = new ListNode(-1);
        ListNode curr = res;
        ListNode iter = head;
        while (iter != null) {
            if (!seen[iter.val]) {
                curr.next = new ListNode(iter.val);
                curr = curr.next;
            }
            iter = iter.next;
        }
        return res.next;
    }
}
