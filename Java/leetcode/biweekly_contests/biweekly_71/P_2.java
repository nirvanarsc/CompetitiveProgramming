package leetcode.biweekly_contests.biweekly_71;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_2 {

    public int[] pivotArray(int[] nums, int pivot) {
        final Deque<Integer> l = new ArrayDeque<>();
        final Deque<Integer> r = new ArrayDeque<>();
        int eq = 0;
        final int n = nums.length;
        final int[] res = new int[n];
        for (int num : nums) {
            if (num < pivot) {
                l.offerLast(num);
            } else if (num == pivot) {
                eq++;
            } else {
                r.offerLast(num);
            }
        }
        for (int i = 0; i < n; i++) {
            if (!l.isEmpty()) {
                res[i] = l.removeFirst();
            } else if (eq > 0) {
                res[i] = pivot;
                eq--;
            } else {
                res[i] = r.removeFirst();
            }
        }
        return res;
    }
}
