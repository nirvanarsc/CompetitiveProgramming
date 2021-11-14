package leetcode.biweekly_contests.biweekly_65;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_3 {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        final int n = items.length;
        final int q = queries.length;
        final int[] res = new int[q];
        final int[][] indexed = new int[q][2];
        for (int i = 0; i < q; i++) {
            indexed[i] = new int[] { queries[i], i };
        }
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(0);
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(indexed, Comparator.comparingInt(a -> a[0]));
        for (int j = 0, i = 0; j < q; j++) {
            while (i < n && items[i][0] <= indexed[j][0]) {
                pq.offer(items[i++][1]);
            }
            res[indexed[j][1]] = pq.element();
        }
        return res;
    }
}
