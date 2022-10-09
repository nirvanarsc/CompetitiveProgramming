package leetcode.weekly_contests.weekly_300_399.weekly_314;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P_3 {

    public String robotWithString(String s) {
        final int n = s.length();
        final char[] w = s.toCharArray();
        final int[] min = new int[n + 1];
        Arrays.fill(min, (int) 1e9);
        for (int i = n - 1; i >= 0; i--) {
            min[i] = Math.min(w[i] - 'a', min[i + 1]);
        }
        final Deque<Character> dq = new ArrayDeque<>();
        final char[] res = new char[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            dq.addFirst(w[i]);
            while (!dq.isEmpty() && dq.getFirst() - 'a' <= min[i + 1]) {
                res[idx++] = dq.removeFirst();
            }
        }
        while (!dq.isEmpty()) {
            res[idx++] = dq.removeFirst();
        }
        return new String(res);
    }
}
