package leetcode.weekly_contests.weekly_100_199.weekly_146;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class P_1130 {

    public int mctFromLeafValues(int[] arr) {
        int res = 0;
        final Deque<Integer> q = new ArrayDeque<>(Collections.singleton(Integer.MAX_VALUE));
        for (int num : arr) {
            while (q.getFirst() <= num) {
                res += q.removeFirst() * Math.min(q.getFirst(), num);
            }
            q.addFirst(num);
        }
        while (q.size() > 2) {
            res += q.removeFirst() * q.getFirst();
        }
        return res;
    }
}
