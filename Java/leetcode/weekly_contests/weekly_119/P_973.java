package leetcode.weekly_contests.weekly_119;

import java.util.PriorityQueue;

public class P_973 {

    public int[][] kClosest(int[][] points, int k) {
        final int[] origin = new int[2];
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(d(origin, b),
                                                                                      d(origin, a)));
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        final int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove();
        }
        return res;
    }

    private static int d(int[] l, int[] r) {
        final int dx = l[0] - r[0];
        final int dy = l[1] - r[1];
        return dx * dx + dy * dy;
    }
}
