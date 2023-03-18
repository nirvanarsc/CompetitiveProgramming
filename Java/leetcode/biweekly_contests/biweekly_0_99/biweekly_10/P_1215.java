package leetcode.biweekly_contests.biweekly_0_99.biweekly_10;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class P_1215 {

    public List<Integer> countSteppingNumbers(int low, int high) {
        if (low > high) {
            return Collections.emptyList();
        }
        final List<Integer> res = new ArrayList<>();
        final Deque<Long> queue = new ArrayDeque<>();
        for (long i = 1; i <= 9; i++) {
            queue.offerLast(i);
        }
        if (low == 0) {
            res.add(0);
        }
        while (!queue.isEmpty()) {
            final long p = queue.poll();
            if (p < high) {
                final long prev = p % 10;
                if (prev > 0) { queue.add(p * 10 + prev - 1); }
                if (prev < 9) { queue.add(p * 10 + prev + 1); }
            }
            if (low <= p && p <= high) {
                res.add((int) p);
            }
        }
        return res;
    }
}
