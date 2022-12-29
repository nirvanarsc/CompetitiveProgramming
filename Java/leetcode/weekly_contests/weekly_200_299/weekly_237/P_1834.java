package leetcode.weekly_contests.weekly_200_299.weekly_237;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_1834 {

    public int[] getOrder(int[][] tasks) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0]
                                                                      ? Integer.compare(a[1], b[1])
                                                                      : Integer.compare(a[0], b[0]));
        final int n = tasks.length;
        final int[][] indexed = new int[n][3];
        for (int i = 0; i < n; i++) {
            indexed[i] = new int[] { tasks[i][0], tasks[i][1], i };
        }
        Arrays.sort(indexed, Comparator.comparingInt(val -> val[0]));
        int time = indexed[0][0];
        int idx = 0;
        final int[] res = new int[n];
        int resIdx = 0;
        while (idx < n || !pq.isEmpty()) {
            while (idx < n && indexed[idx][0] <= time) {
                pq.offer(new int[] { indexed[idx][1], indexed[idx][2] });
                idx++;
            }
            if (!pq.isEmpty()) {
                final int[] curr = pq.remove();
                time += curr[0];
                res[resIdx++] = curr[1];
            } else {
                time = indexed[idx][0];
            }
        }
        return res;
    }
}
