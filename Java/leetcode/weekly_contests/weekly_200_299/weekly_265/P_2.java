package leetcode.weekly_contests.weekly_200_299.weekly_265;

import java.util.ArrayList;
import java.util.List;

import utils.DataStructures.ListNode;

public class P_2 {

    int prev = -1;

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int idx = 0;
        final List<Integer> list = new ArrayList<>();
        for (ListNode iter = head; iter != null; iter = iter.next, idx++) {
            if (prev != -1 && iter.next != null) {
                if (prev < iter.val && iter.val > iter.next.val) {
                    list.add(idx);
                }
                if (prev > iter.val && iter.val < iter.next.val) {
                    list.add(idx);
                }
            }
            prev = iter.val;
        }
        if (list.size() < 2) {
            return new int[] { -1, -1 };
        }
        final int max = list.get(list.size() - 1) - list.get(0);
        int min = (int) 1e9;
        for (int i = 0; i < list.size() - 1; i++) {
            min = Math.min(min, list.get(i + 1) - list.get(i));
        }
        return new int[] { min, max };
    }
}
