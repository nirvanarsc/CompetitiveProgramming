package leetcode.weekly_contests.weekly_90;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_857 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public double mincostToHireWorkers(int[] q, int[] w, int K) {
        final double[][] workers = new double[q.length][2];
        for (int i = 0; i < q.length; ++i) {
            workers[i] = new double[] { (double) w[i] / q[i], q[i] };
        }
        Arrays.sort(workers, Comparator.comparingDouble(a -> a[0]));
        double res = Double.MAX_VALUE, qsum = 0;
        final PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (double[] worker : workers) {
            qsum += worker[1];
            pq.add(worker[1]);
            if (pq.size() > K) {
                qsum -= pq.remove();
            }
            if (pq.size() == K) {
                res = Math.min(res, qsum * worker[0]);
            }
        }
        return res;
    }
}
