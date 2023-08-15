package leetcode.weekly_contests.weekly_300_399.weekly_339;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.TreeSet;

public class P_4 {

    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        final int[] res = new int[n];
        //noinspection unchecked
        final TreeSet<Integer>[] set = new TreeSet[] { new TreeSet<>(), new TreeSet<>() };
        for (int i = 0; i < n; ++i) {
            set[i % 2].add(i);
            res[i] = i == p ? 0 : -1;
        }
        set[p % 2].remove(p);
        for (int i : banned) {
            set[i % 2].remove(i);
        }
        final Deque<Integer> deque = new ArrayDeque<>(List.of(p));
        while (!deque.isEmpty()) {
            final int u = deque.removeFirst();
            final int i = Math.abs(u - k + 1);
            Integer j = set[i % 2].ceiling(i);
            while (j != null && j < n - Math.abs(n - u - k)) {
                deque.offerLast(j);
                res[j] = res[u] + 1;
                set[i % 2].remove(j);
                j = set[i % 2].higher(j);
            }
        }
        return res;
    }
}
