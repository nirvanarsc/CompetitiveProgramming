package leetcode.biweekly_contests.biweekly_0_99.biweekly_40;

import utils.DataStructures.ListNode;

public class P_1669 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        final ListNode insertEnd = getLast(list2);
        final ListNode res = new ListNode(-1);
        res.next = list1;
        ListNode iter = res;
        ListNode insertHereA = null;
        ListNode insertHereB = null;
        while (iter != null) {
            if (iter.next != null && iter.next.val == a) {
                insertHereA = iter;
            }
            if (iter.val == b) {
                insertHereB = iter;
            }
            iter = iter.next;
        }
        assert insertHereA != null;
        assert insertHereB.next != null;
        insertHereA.next = list2;
        insertEnd.next = insertHereB.next;
        return res.next;
    }

    private static ListNode getLast(ListNode list) {
        ListNode res = null;
        while (list != null) {
            if (list.next == null) {
                res = list;
            }
            list = list.next;
        }
        return res;
    }
}
