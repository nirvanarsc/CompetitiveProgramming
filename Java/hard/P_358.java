package hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class P_358 {

    static class Pair {
        char c;
        int count;

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String rearrangeString(String s, int k) {
        final PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));
        final Deque<Pair> q = new ArrayDeque<>();
        final int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (count[c - 'a'] > 0) {
                pq.offer(new Pair(c, count[c - 'a']));
            }
        }
        final StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            final Pair curr = pq.remove();
            sb.append(curr.c);
            curr.count -= 1;
            q.offerLast(curr);
            if (q.size() < k) {
                continue;
            }
            final Pair fromQ = q.removeFirst();
            if (fromQ.count > 0) {
                pq.offer(fromQ);
            }
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}
