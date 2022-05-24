package leetcode.weekly_contests.weekly_0_99.weekly_38;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_630 {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(val -> val[1]));
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int t = 0;
        for (int[] course : courses) {
            if (t + course[0] <= course[1]) {
                t += course[0];
                pq.offer(course);
            } else if (!pq.isEmpty() && pq.element()[0] > course[0]) {
                final int[] curr = pq.remove();
                t += course[0] - curr[0];
                pq.offer(course);
            }
        }
        return pq.size();
    }
}
