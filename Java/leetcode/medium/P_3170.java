package leetcode.medium;

import java.util.PriorityQueue;

public class P_3170 {

    public String clearStars(String s) {
        final int n = s.length();
        final boolean[] seen = new boolean[n];
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0]
                                                                      ? Integer.compare(a[0], b[0])
                                                                      : Integer.compare(b[1], a[1]));
        for (int i = 0; i < n; i++) {
            final char c = s.charAt(i);
            if (c == '*') {
                if (!pq.isEmpty()) {
                    final int[] pop = pq.poll();
                    final int u = pop[1];
                    seen[u] = true;
                }
            } else {
                pq.offer(new int[] { c, i });
            }
        }
        final StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!seen[i] && s.charAt(i) != '*') {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
