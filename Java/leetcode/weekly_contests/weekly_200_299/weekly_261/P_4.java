package leetcode.weekly_contests.weekly_200_299.weekly_261;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_4 {

    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int total = 0;
        final int n = s.length();
        final char[] w = s.toCharArray();
        final Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (w[i] == letter) {
                total++;
            }
        }
        for (int i = 0; i < n; i++) {
            final char c = w[i];
            while (!dq.isEmpty() &&
                   dq.getFirst() > c &&
                   (n - i + dq.size() > k) &&
                   (dq.getFirst() != letter || total > repetition)) {
                if (dq.removeFirst() == letter) {
                    repetition++;
                }
            }
            if (dq.size() < k) {
                if (c == letter) {
                    dq.addFirst(c);
                    repetition--;
                } else if (k - dq.size() > repetition) {
                    dq.addFirst(c);
                }
            }
            if (c == letter) {
                total--;
            }
        }
        final StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.removeLast());
        }
        return sb.toString();
    }
}
