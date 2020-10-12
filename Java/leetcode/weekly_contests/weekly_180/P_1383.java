package leetcode.weekly_contests.weekly_180;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P_1383 {

    private static final int MOD = (int) (1e9 + 7);

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        final int[][] se = new int[n][];
        for (int i = 0; i < n; i++) {
            se[i] = new int[] { speed[i], efficiency[i] };
        }
        Arrays.sort(se, (a, b) -> Integer.compare(b[1], a[1]));
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        long s = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            pq.add(se[i][0]);
            s += se[i][0];
            if (pq.size() > k) {
                s -= pq.remove();
            }
            max = Math.max(max, s * se[i][1]);
        }
        return (int) (max % MOD);
    }
}
