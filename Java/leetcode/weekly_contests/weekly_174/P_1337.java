package leetcode.weekly_contests.weekly_174;

import java.util.PriorityQueue;

public class P_1337 {

    public int[] kWeakestRows(int[][] mat, int k) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] == b[1] ? Integer.compare(b[0], a[0]) : Integer.compare(b[1], a[1]));
        for (int i = 0; i < mat.length; i++) {
            pq.add(new int[] { i, lowerBound(mat[i]) });
            if (pq.size() > k) {
                pq.remove();
            }
        }
        final int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.remove()[0];
        }
        return res;
    }

    private static int lowerBound(int[] row) {
        int lo = 0, hi = row.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (row[mid] == 1) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
