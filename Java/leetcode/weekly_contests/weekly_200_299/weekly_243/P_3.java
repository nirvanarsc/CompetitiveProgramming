package leetcode.weekly_contests.weekly_200_299.weekly_243;

import java.util.PriorityQueue;

public class P_3 {

    public int[] assignTasks(int[] servers, int[] tasks) {
        //noinspection Convert2MethodRef
        final PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> byWeightAndIndex(a, b));
        final PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[2] == b[2]
                                                                        ? byWeightAndIndex(a, b)
                                                                        : Integer.compare(a[2], b[2]));
        final int n = servers.length;
        final int m = tasks.length;
        for (int i = 0; i < n; i++) {
            free.add(new int[] { servers[i], i, 0 });
        }
        final int[] res = new int[m];
        for (int time = 0; time < m; time++) {
            final int t = tasks[time];
            while (!busy.isEmpty() && busy.element()[2] <= time) {
                free.add(busy.poll());
            }
            final int[] curr;
            if (free.isEmpty()) {
                curr = busy.remove();
                res[time] = curr[1];
                curr[2] += t;
            } else {
                curr = free.remove();
                res[time] = curr[1];
                curr[2] = time + t;
            }
            busy.add(curr);
        }
        return res;
    }

    private static int byWeightAndIndex(int[] a, int[] b) {
        return (a[0] == b[0]) ? Integer.compare(a[1], b[1])
                              : Integer.compare(a[0], b[0]);
    }
}
