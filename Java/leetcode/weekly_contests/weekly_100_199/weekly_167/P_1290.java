package leetcode.weekly_contests.weekly_100_199.weekly_167;

import utils.DataStructures.ListNode;

public class P_1290 {

    public int getDecimalValue(ListNode head) {
        int res = 0;
        for (ListNode iter = head; iter != null; iter = iter.next) {
            res <<= 1;
            res |= iter.val;
        }
        return res;
    }
}
