package leetcode.weekly_contests.weekly_180;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_1383 {

    private static final int MOD = (int) (1e9 + 7);

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
        final int[][] paired = new int[n][2];
        for (int i = 0; i < n; i++) {
            paired[i] = new int[] { speed[i], efficiency[i] };
        }
        Arrays.sort(paired, (a, b) -> Integer.compare(b[1], a[1]));
        long speedSum = 0;
        long res = 0;
        int j = 0;
        while (j < n) {
            final int currE = paired[j][1];
            while (j < n && currE == paired[j][1]) {
                speedSum += paired[j][0];
                pq.offer(paired[j][0]);
                if (pq.size() > k) {
                    speedSum -= pq.remove();
                }
                j++;
            }
            res = Math.max(res, speedSum * currE);
        }
        return (int) (res % MOD);
    }
}
