package medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class P_433 {

    public int minMutation(String start, String end, String[] bank) {
        final Set<String> set = new HashSet<>(Arrays.asList(bank));
        final Deque<String> q = new ArrayDeque<>(Collections.singleton(start));
        final char[] validChars = { 'A', 'C', 'G', 'T' };
        for (int i = 0; !q.isEmpty(); i++) {
            for (int size = q.size(); size > 0; size--) {
                final String curr = q.removeFirst();
                if (curr.equals(end)) {
                    return i;
                }
                final char[] chars = curr.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    final char t = chars[j];
                    for (char c : validChars) {
                        chars[j] = c;
                        final String next = new String(chars);
                        if (set.remove(next)) {
                            q.offerLast(next);
                        }
                    }
                    chars[j] = t;
                }
            }
        }
        return -1;
    }
}
