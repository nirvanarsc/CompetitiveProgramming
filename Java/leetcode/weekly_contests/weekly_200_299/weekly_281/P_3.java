package leetcode.weekly_contests.weekly_200_299.weekly_281;

import java.util.PriorityQueue;

public class P_3 {

    public String repeatLimitedString(String s, int repeatLimit) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        final int[] f = new int[26];
        for (char c : s.toCharArray()) {
            f[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (f[i] > 0) {
                pq.offer(new int[] { i, f[i] });
            }
        }
        final StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            final int[] u = pq.remove();
            final int take = Math.min(repeatLimit, u[1]);
            final char c = (char) ('a' + u[0]);
            //noinspection StringRepeatCanBeUsed
            for (int i = 0; i < take; i++) {
                sb.append(c);
            }
            if (u[1] > take) {
                if (pq.isEmpty()) {
                    break;
                }
                final int[] v = pq.remove();
                sb.append((char) ('a' + v[0]));
                if (v[1] > 1) {
                    v[1]--;
                    pq.offer(v);
                }
                u[1] -= take;
                pq.offer(u);
            }
        }
        return sb.toString();
    }
}
