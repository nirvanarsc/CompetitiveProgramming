package weekly_contests.weekly_119;

import java.util.PriorityQueue;

public class P_973 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int[][] kClosest(int[][] points, int K) {
        final int[][] res = new int[K][2];
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare(dist(b), dist(a)));
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        for (int i = 0; i < K; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    private static double dist(int[] b) {
        return b[0] * b[0] + b[1] * b[1];
    }
}
