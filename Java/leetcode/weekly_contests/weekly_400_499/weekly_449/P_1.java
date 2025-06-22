package leetcode.weekly_contests.weekly_400_499.weekly_449;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_1 {

    public int minDeletion(String s, int k) {
        final int[] f = new int[26];
        for (char c : s.toCharArray()) {
            f[c - 'a']++;
        }
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int u : f) {
            if (u > 0) {
                pq.offer(u);
            }
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) {
                res += pq.remove();
            }
        }
        return s.length() - res;
    }
}
