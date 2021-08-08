package leetcode.weekly_contests.weekly_253;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_3 {

    public int minSwaps(String s) {
        final char[] w = s.toCharArray();
        int close = 0;
        final Deque<Integer> left = new ArrayDeque<>();
        for (int i = w.length - 1; i >= 0; i--) {
            if (w[i] == '[') {
                if (close == 0) {
                    left.offerLast(i);
                } else {
                    close--;
                }
            } else {
                close++;
            }
        }
        int open = 0;
        int res = 0;
        for (int i = 0; i < w.length; i++) {
            if (w[i] == ']') {
                if (open == 0) {
                    res++;
                    final int swap = left.removeFirst();
                    w[i] = '[';
                    w[swap] = ']';
                    open++;
                } else {
                    open--;
                }
            } else {
                open++;
            }
        }
        return res;
    }
}
