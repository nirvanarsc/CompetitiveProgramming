package leetcode.weekly_contests.weekly_38;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_630 {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int time = 0;
        for (int[] c : courses) {
            time += c[0];
            pq.add(c[0]);
            if (time > c[1]) {
                time -= pq.remove();
            }
        }
        return pq.size();
    }
}
