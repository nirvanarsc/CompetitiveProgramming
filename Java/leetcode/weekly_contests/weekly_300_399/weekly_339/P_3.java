package leetcode.weekly_contests.weekly_300_399.weekly_339;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_3 {

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        final int n = reward1.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += reward2[i];
        }
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.offer(reward1[i] - reward2[i]);
        }
        for (int i = 0; i < k; i++) {
            res += pq.remove();
        }
        return res;
    }
}
