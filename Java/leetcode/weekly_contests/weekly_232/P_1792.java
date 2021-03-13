package leetcode.weekly_contests.weekly_232;

import java.util.PriorityQueue;

public class P_1792 {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int full = 0;
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare(f(b), f(a)));
        for (int[] c : classes) {
            if (c[0] == c[1]) {
                full++;
            } else {
                pq.offer(c);
            }
        }
        if (pq.isEmpty()) {
            return 1.0;
        }
        for (int i = 0; i < extraStudents; i++) {
            final int[] c = pq.remove();
            c[0]++;
            c[1]++;
            pq.offer(c);
        }
        double res = full;
        while (!pq.isEmpty()) {
            final int[] c = pq.remove();
            res += (double) c[0] / c[1];
        }
        return res / classes.length;
    }

    private static double f(int[] a) {
        return (a[1] - a[0]) / ((double) a[1] * (a[1] + 1));
    }
}
