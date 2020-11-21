package binarysearch.weekly_33;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_2 {

    public int[] solve(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));
        final int[] res = new int[tasks.length];
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] == b[2]
                                                                      ? Integer.compare(a[0], b[0])
                                                                      : Integer.compare(a[2], b[2]));
        int idx = 0;
        int time = tasks[0][1];
        int j = 0;
        while (idx < tasks.length) {
            if (pq.isEmpty()) {
                time = Math.max(time, tasks[j][1]);
            }
            while (j < tasks.length && tasks[j][1] <= time) {
                pq.offer(tasks[j++]);
            }
            final int[] curr = pq.remove();
            res[idx++] = curr[0];
            time += curr[2];
        }
        return res;
    }
}
