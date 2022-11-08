package leetcode.weekly_contests.weekly_200_299.weekly_201;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1544 {

    public String makeGood(String s) {
        final Deque<Character> dq = new ArrayDeque<>();
        final int n = s.length();
        final char[] w = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && Math.abs(dq.getFirst() - w[i]) == 32) {
                dq.removeFirst();
            } else {
                dq.addFirst(w[i]);
            }
        }
        final char[] res = new char[dq.size()];
        int index = dq.size() - 1;
        while (!dq.isEmpty()) {
            res[index--] = dq.removeFirst();
        }
        return new String(res);
    }
}
