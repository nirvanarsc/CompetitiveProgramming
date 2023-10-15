package leetcode.weekly_contests.weekly_300_399.weekly_364;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class P_2 {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        final int n = maxHeights.size();
        final long[] left = f(maxHeights, n);
        Collections.reverse(maxHeights);
        final long[] right = f(maxHeights, n);
        Collections.reverse(maxHeights);
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, left[i] + right[n - i - 1] - maxHeights.get(i));
        }
        return res;
    }

    private static long[] f(List<Integer> list, int n) {
        final long[] res = new long[n];
        final Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(-1);
        long curr = 0;
        for (int i = 0; i < n; i++) {
            while (stack.size() > 1 && list.get(stack.getFirst()) > list.get(i)) {
                final int j = stack.removeFirst();
                curr -= (long) (j - stack.getFirst()) * list.get(j);
            }
            curr += (long) (i - stack.getFirst()) * list.get(i);
            stack.addFirst(i);
            res[i] = curr;
        }
        return res;
    }
}
