package leetcode.biweekly_contests.biweekly_69;

import java.util.ArrayList;
import java.util.List;

import utils.DataStructures.ListNode;

public class P_2 {

    public int pairSum(ListNode head) {
        final List<Integer> list = new ArrayList<>();
        for (ListNode iter = head; iter != null; iter = iter.next) {
            list.add(iter.val);
        }
        int l = 0;
        int r = list.size() - 1;
        int res = 0;
        while (l < r) {
            res = Math.max(res, list.get(l++) + list.get(r--));
        }
        return res;
    }
}
