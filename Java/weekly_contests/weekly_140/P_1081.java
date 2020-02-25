package weekly_contests.weekly_140;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1081 {

    public String smallestSubsequence(String text) {
        final Deque<Integer> stack = new ArrayDeque<>();
        final int[] last = new int[26];
        final int[] seen = new int[26];
        for (int i = 0; i < text.length(); ++i) {
            last[text.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < text.length(); ++i) {
            final int c = text.charAt(i) - 'a';
            if (seen[c]++ > 0) { continue; }
            while (!stack.isEmpty() && stack.peekFirst() > c && i < last[stack.peekFirst()]) {
                seen[stack.removeFirst()] = 0;
            }
            stack.push(c);
        }
        final StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) { sb.append((char) ('a' + stack.removeLast())); }
        return sb.toString();
    }
}
