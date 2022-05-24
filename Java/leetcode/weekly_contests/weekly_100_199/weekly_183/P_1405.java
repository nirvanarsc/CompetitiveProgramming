package leetcode.weekly_contests.weekly_100_199.weekly_183;

import java.util.PriorityQueue;

public class P_1405 {

    static class Pair {
        int n;
        char c;

        Pair(int n, char c) {
            this.n = n;
            this.c = c;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        final StringBuilder sb = new StringBuilder();
        final PriorityQueue<Pair> pq = new PriorityQueue<>((v1, v2) -> Integer.compare(v2.n, v1.n));
        if (a > 0) { pq.add(new Pair(a, 'a')); }
        if (b > 0) { pq.add(new Pair(b, 'b')); }
        if (c > 0) { pq.add(new Pair(c, 'c')); }
        while (pq.size() > 1) {
            final Pair top = pq.remove();
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == top.c) {
                final Pair second = pq.remove();
                sb.append(second.c);
                second.n--;
                if (second.n > 0) {
                    pq.add(second);
                }
            } else {
                final int min = Math.min(top.n, 2);
                for (int i = 0; i < min; i++) {
                    sb.append(top.c);
                    top.n--;
                }
            }
            if (top.n > 0) {
                pq.add(top);
            }
        }
        if (!pq.isEmpty()) {
            final Pair last = pq.remove();
            if (sb.charAt(sb.length() - 1) != last.c) {
                final int min = Math.min(last.n, 2);
                for (int i = 0; i < min; i++) {
                    sb.append(last.c);
                    last.n--;
                }
            }
        }
        return sb.toString();
    }
}
