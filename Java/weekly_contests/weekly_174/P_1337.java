package weekly_contests.weekly_174;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P_1337 {

    public int[] kWeakestRows(int[][] mat, int k) {
        final int[] res = new int[k];
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            map.put(i, numOnes(mat[i]));
        }
        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            list.add(i);
        }
        list.sort((a, b) -> {
            if (a.equals(b)) {
                return Integer.compare(a, b);
            }
            return Integer.compare(map.get(a), map.get(b));
        });
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] kWeakestRowsPQ(int[][] mat, int k) {
        final int[] res = new int[k];
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(b[0], a[0]);
        });
        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[] { numOnes(mat[i]), i });
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (k > 0) {
            res[--k] = pq.remove()[1];
        }
        return res;
    }

    private static int numOnes(int[] row) {
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
