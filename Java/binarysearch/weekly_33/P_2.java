package binarysearch.weekly_33;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_2 {

    public int[] solve(int[][] tasks) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0]
                                                                      ? Integer.compare(a[1], b[1])
                                                                      : Integer.compare(a[0], b[0]));
        Arrays.sort(tasks, Comparator.comparingInt(val -> val[1]));
        final int n = tasks.length;
        final int[] res = new int[n];
        int time = tasks[0][1];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (pq.isEmpty() && time < tasks[j][1]) {
                time = tasks[j][1];
            }
            while (j < n && time >= tasks[j][1]) {
                pq.offer(new int[] { tasks[j][2], tasks[j][0] });
                j++;
            }
            final int[] curr = pq.remove();
            time += curr[0];
            res[i] = curr[1];
        }
        return res;
    }
}
