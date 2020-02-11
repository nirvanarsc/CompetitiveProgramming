package weekly_156;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1209 {

    public String removeDuplicates(String s, int k) {
        final Deque<Character> deque = new ArrayDeque<>();
        final Deque<Integer> counts = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!deque.isEmpty() && deque.getFirst() == c) {
                final int t = counts.removeFirst();
                if (t == k - 1) {
                    deque.removeFirst();
                } else {
                    counts.addFirst(t + 1);
                }
            } else {
                deque.addFirst(c);
                counts.addFirst(1);
            }
        }
        final StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            final char c = deque.removeLast();
            final int cnt = counts.removeLast();
            for (int i = 0; i < cnt; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String removeDuplicatesImproved(String s, int k) {
        int i = 0;
        final int[] count = new int[s.length()];
        final char[] array = s.toCharArray();

        for (int j = 0; j < s.length(); i++, j++) {
            array[i] = array[j];
            count[i] = (i > 0 && array[i] == array[i - 1]) ? count[i - 1] + 1 : 1;
            if (count[i] == k) {
                i -= k;
            }
        }

        return new String(array, 0, i);
    }

    public String removeDuplicatesPrimitiveStack(String s, int k) {
        int i = 0;
        final char[] stack = new char[s.length()];
        for (int j = 0; j < s.length(); ++j) {
            if (i > k - 2 && allMatch(s, k, i, j, stack)) {
                i -= k - 1;
            } else {
                stack[i++] = s.charAt(j);
            }
        }
        return new String(stack, 0, i);
    }

    private static boolean allMatch(String s, int k, int i, int j, char[] stack) {
        for (int t = i - k + 1; t < i; t++) {
            if (stack[t] != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
