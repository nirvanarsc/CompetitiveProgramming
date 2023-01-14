package leetcode.weekly_contests.weekly_300_399.weekly_327;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_4 {

    public int findCrossingTime(int n, int k, int[][] time) {
        int res = 0;
        int free = 0;
        final PriorityQueue<int[]> l = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        final PriorityQueue<int[]> r = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        final PriorityQueue<int[]> ll = new PriorityQueue<>((a, b) -> a[0] != b[0]
                                                                      ? Integer.compare(b[0], a[0])
                                                                      : Integer.compare(b[1], a[1]));
        final PriorityQueue<int[]> rr = new PriorityQueue<>((a, b) -> a[0] != b[0]
                                                                      ? Integer.compare(b[0], a[0])
                                                                      : Integer.compare(b[1], a[1]));
        for (int i = 0; i < k; i++) {
            ll.add(new int[] { time[i][0] + time[i][2], i });
        }
        while (n > 0 || !r.isEmpty() || !rr.isEmpty()) {
            if (rr.isEmpty()
                && (r.isEmpty() || r.element()[0] > free)
                && (n == 0 || ll.isEmpty() && (l.isEmpty() || l.element()[0] > free))) {
                int curr = (int) 2e9;
                if (n > 0 && !l.isEmpty()) {
                    curr = Math.min(curr, l.element()[0]);
                }
                if (!r.isEmpty()) {
                    curr = Math.min(curr, r.element()[0]);
                }
                free = curr;
            }
            while (!l.isEmpty() && l.element()[0] <= free) {
                final int idx = l.remove()[1];
                ll.add(new int[] { time[idx][0] + time[idx][2], idx });
            }
            while (!r.isEmpty() && r.element()[0] <= free) {
                final int idx = r.remove()[1];
                rr.add(new int[] { time[idx][0] + time[idx][2], idx });
            }
            if (!rr.isEmpty()) {
                final int idx = rr.remove()[1];
                free += time[idx][2];
                if (n > 0) {
                    l.add(new int[] { free + time[idx][3], idx });
                } else {
                    res = Math.max(res, free);
                }
            } else {
                final int idx = ll.remove()[1];
                free += time[idx][0];
                r.add(new int[] { free + time[idx][1], idx });
                n--;
            }
        }
        return res;
    }
}
