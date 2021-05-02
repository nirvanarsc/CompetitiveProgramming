package leetcode.weekly_contests.weekly_239;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

@SuppressWarnings("ComparatorCombinators")
public class P_1851 {

    public int[] minInterval(int[][] intervals, int[] queries) {
        final int n = intervals.length;
        final int q = queries.length;
        final int[][] indexed = new int[q][2];
        for (int i = 0; i < q; i++) {
            indexed[i] = new int[] { queries[i], i };
        }
        final int[] res = new int[q];
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(indexed, (a, b) -> Integer.compare(a[0], b[0]));
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        final Map<Integer, Integer> f = new HashMap<>();
        final TreeSet<Integer> ts = new TreeSet<>();
        int j = 0;
        for (int i = 0; i < q; i++) {
            final int curr = indexed[i][0];
            while (j < n && intervals[j][0] <= curr) {
                final int size = intervals[j][1] - intervals[j][0] + 1;
                if (f.merge(size, 1, Integer::sum) == 1) {
                    ts.add(size);
                }
                pq.add(intervals[j]);
                j++;
            }
            while (!pq.isEmpty() && pq.element()[1] < curr) {
                final int[] rem = pq.remove();
                final int size = rem[1] - rem[0] + 1;
                if (f.merge(size, -1, Integer::sum) == 0) {
                    ts.remove(size);
                }
            }
            res[indexed[i][1]] = ts.isEmpty() ? -1 : ts.first();
        }
        return res;
    }
}
