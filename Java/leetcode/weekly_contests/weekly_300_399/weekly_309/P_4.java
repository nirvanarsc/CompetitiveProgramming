package leetcode.weekly_contests.weekly_300_399.weekly_309;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_4 {

    public int mostBooked(int n, int[][] meetings) {
        final int[] f = new int[n];
        final PriorityQueue<Integer> available = new PriorityQueue<>();
        final PriorityQueue<long[]> busy = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        for (int i = 0; i < n; i++) {
            available.add(i);
        }
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        long time = -1;
        for (int[] meeting : meetings) {
            time = Math.max(time, meeting[0]);
            time = Math.max(time, available.isEmpty() ? busy.element()[0] : time);
            while (!busy.isEmpty() && time >= busy.element()[0]) {
                available.add((int) busy.remove()[1]);
            }
            final int u = available.remove();
            f[u]++;
            busy.add(new long[] { time + (meeting[1] - meeting[0]), u });
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, f[i]);
        }
        for (int i = 0; i < n; i++) {
            if (f[i] == max) {
                return i;
            }
        }
        return -1;
    }
}
