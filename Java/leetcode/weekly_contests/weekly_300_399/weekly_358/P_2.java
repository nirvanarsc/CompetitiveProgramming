package leetcode.weekly_contests.weekly_300_399.weekly_358;

import java.util.ArrayList;
import java.util.List;

import utils.DataStructures.ListNode;

public class P_2 {

    public ListNode doubleIt(ListNode head) {
        final List<Integer> list = new ArrayList<>();
        ListNode iter = head;
        while (iter != null) {
            list.add(iter.val);
            iter = iter.next;
        }
        ListNode res = new ListNode(-1);
        int carry = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int u = 2 * list.get(i) + carry;
            carry = u / 10;
            u %= 10;
            res = f(res, u);
        }
        if (carry > 0) {
            res = f(res, carry);
        }
        return res.next;
    }

    private static ListNode f(ListNode res, int carry) {
        res.val = carry;
        final ListNode prev = new ListNode(-1);
        prev.next = res;
        res = prev;
        return res;
    }
}
