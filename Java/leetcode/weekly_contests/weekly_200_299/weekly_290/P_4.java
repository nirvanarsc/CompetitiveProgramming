package leetcode.weekly_contests.weekly_200_299.weekly_290;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_4 {

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        final int n = flowers.length;
        final int m = persons.length;
        final int[][] indexed = new int[m][2];
        for (int i = 0; i < m; i++) {
            indexed[i] = new int[] { persons[i], i };
        }
        Arrays.sort(indexed, Comparator.comparingInt(a -> a[0]));
        final int[] res = new int[m];
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx = 0;
        Arrays.sort(flowers, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < m; i++) {
            while (idx < n && flowers[idx][0] <= indexed[i][0]) {
                pq.offer(flowers[idx++][1]);
            }
            while (!pq.isEmpty() && pq.element() < indexed[i][0]) {
                pq.remove();
            }
            res[indexed[i][1]] = pq.size();
        }
        return res;
    }
}
