package leetcode.weekly_contests.weekly_0_99.weekly_48;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_670 {

    public int maximumSwap(int num) {
        final char[] str = String.valueOf(num).toCharArray();
        final Deque<int[]> deque = new ArrayDeque<>();
        for (int i = str.length - 1; i >= 0; i--) {
            final int curr = str[i] - '0';
            if (deque.isEmpty() || deque.peekFirst()[0] < curr) {
                deque.addFirst(new int[] { curr, i });
            }
        }
        for (int i = 0; i < str.length; i++) {
            final int curr = str[i] - '0';
            if (deque.isEmpty()) {
                return num;
            } else if (curr < deque.peekFirst()[0]) {
                final char t = str[i];
                str[i] = str[deque.peekFirst()[1]];
                str[deque.peekFirst()[1]] = t;
                return Integer.valueOf(new String(str));
            } else if (i == deque.peek()[1]) {
                deque.removeFirst();
            }
        }
        return num;
    }
}
