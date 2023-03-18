package leetcode.biweekly_contests.biweekly_0_99.biweekly_96;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_3 {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        final int n = nums1.length;
        final int[][] paired = new int[n][2];
        for (int i = 0; i < n; i++) {
            paired[i] = new int[] { nums2[i], nums1[i] };
        }
        Arrays.sort(paired, Comparator.comparingInt(a -> a[0]));
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 1; i < n; i++) {
            pq.offer(new int[] { paired[i][1], i });
        }
        final boolean[] seen = new boolean[n];
        long s = paired[0][1];
        for (int i = 0; i < k - 1; i++) {
            final int[] pop = pq.remove();
            seen[pop[1]] = true;
            s += pop[0];
        }
        long res = s * paired[0][0];
        for (int i = 1; i <= n - k; i++) {
            s -= paired[i - 1][1];
            if (!seen[i]) {
                s += paired[i][1];
                seen[i] = true;
            } else {
                while (seen[pq.element()[1]]) {
                    pq.remove();
                }
                final int[] pop = pq.remove();
                seen[pop[1]] = true;
                s += pop[0];
            }
            res = Math.max(res, s * paired[i][0]);
        }
        return res;
    }
}
