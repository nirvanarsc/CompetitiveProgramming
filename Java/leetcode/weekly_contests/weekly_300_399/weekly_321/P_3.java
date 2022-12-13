package leetcode.weekly_contests.weekly_300_399.weekly_321;

import java.util.ArrayList;
import java.util.List;

import utils.DataStructures.ListNode;

public class P_3 {

    public ListNode removeNodes(ListNode head) {
        final List<Integer> list = new ArrayList<>();
        ListNode iter = head;
        while (iter != null) {
            list.add(iter.val);
            iter = iter.next;
        }
        final int n = list.size();
        final int[] suffMax = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffMax[i] = Math.max(list.get(i), suffMax[i + 1]);
        }
        final ListNode res = new ListNode(-1);
        ListNode resIter = res;
        iter = head;
        for (int i = 0; i < n; i++) {
            if (list.get(i) >= suffMax[i + 1]) {
                resIter.next = iter;
                resIter = resIter.next;
            }
            iter = iter.next;
        }
        return res.next;
    }
}
