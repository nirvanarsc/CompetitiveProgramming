package leetcode.biweekly_contests.biweekly_100_199.biweekly_110;

import java.util.ArrayList;
import java.util.List;

import utils.DataStructures.ListNode;

public class P_2 {

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        final List<Integer> list = new ArrayList<>();
        final List<Integer> gcd = new ArrayList<>();
        ListNode iter = head;
        while (iter != null) {
            list.add(iter.val);
            iter = iter.next;
        }
        final ListNode res = new ListNode(-1);
        iter = res;
        for (int i = 0; i < list.size() - 1; i++) {
            gcd.add(gcd(list.get(i), list.get(i + 1)));
        }
        for (int i = 0; i < list.size(); i++) {
            iter.next = new ListNode(list.get(i));
            iter = iter.next;
            if (i != gcd.size()) {
                iter.next = new ListNode(gcd.get(i));
                iter = iter.next;
            }
        }
        return res.next;
    }
}
