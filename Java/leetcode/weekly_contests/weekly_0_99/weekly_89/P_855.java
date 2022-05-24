package leetcode.weekly_contests.weekly_0_99.weekly_89;

import java.util.PriorityQueue;

public class P_855 {

    @SuppressWarnings({ "SubtractionInCompareTo", "ConstantConditions" })
    static class ExamRoom {
        private final PriorityQueue<int[]> pq;
        private final int n;

        ExamRoom(int n) {
            this.n = n;
            pq = new PriorityQueue<>((a, b) -> {
                final int left = (a[1] - a[0]) / 2;
                final int right = (b[1] - b[0]) / 2;
                if (left == right) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(right, left);
            });
        }

        public int seat() {
            if (pq.isEmpty()) {
                pq.offer(new int[] { 0, 2 * (n - 1) });
                return 0;
            } else {
                final int[] longest = pq.poll();
                final int result = longest[0] + (longest[1] - longest[0]) / 2;
                if (result != 0) {
                    pq.offer(new int[] { longest[0], result });
                }
                if (result != n - 1) {
                    pq.offer(new int[] { result, longest[1] });
                }
                return result;
            }
        }

        public void leave(int p) {
            if (pq.size() == 1 && (pq.peek()[1] >= n || pq.peek()[0] < 0)) {
                pq.clear();
                return;
            }
            int[] p1 = null, p2 = null;
            for (int[] pair : pq) {
                if (pair[1] == p) {
                    p1 = pair;
                }
                if (pair[0] == p) {
                    p2 = pair;
                }
            }
            if (p1 != null) {
                pq.remove(p1);
            }
            if (p2 != null) {
                pq.remove(p2);
            }
            if (p1 == null || p1[0] < 0) {
                p1 = new int[] { -p2[1], p };
            }
            if (p2 == null || p2[1] >= n) {
                p2 = new int[] { p, p1[0] + 2 * (n - p1[0] - 1) };
            }
            pq.offer(new int[] { p1[0], p2[1] });
        }
    }
}
