package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_316 {

    public String removeDuplicateLetters(String s) {
        final Deque<Integer> dq = new ArrayDeque<>();
        final int[] lastIdx = new int[26];
        final int n = s.length();
        final char[] w = s.toCharArray();
        int mask = 0;
        int last = 0;
        for (int i = 0; i < n; i++) {
            lastIdx[w[i] - 'a'] = i;
        }
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.getFirst() > w[i] - 'a' &&
                   !isSet(last, dq.getFirst()) && !isSet(mask, w[i] - 'a')) {
                mask ^= 1 << dq.removeFirst();
            }
            if (!isSet(mask, w[i] - 'a')) {
                mask ^= 1 << w[i] - 'a';
                dq.addFirst(w[i] - 'a');
            }
            if (lastIdx[w[i] - 'a'] == i) {
                last ^= 1 << w[i] - 'a';
            }
        }
        final char[] res = new char[dq.size()];
        for (int i = 0; !dq.isEmpty(); i++) {
            res[i] = (char) (dq.removeLast() + 'a');
        }
        return new String(res);
    }

    private static boolean isSet(int mask, int idx) {
        return (mask & (1 << idx)) != 0;
    }
}
