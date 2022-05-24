package leetcode.weekly_contests.weekly_200_299.weekly_201;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1544 {

    public String makeGood(String s) {
        final Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - s.charAt(i)) == 32) {
                stack.removeFirst();
            } else {
                stack.addFirst(s.charAt(i));
            }
        }
        final char[] res = new char[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[index--] = stack.removeFirst();
        }
        return new String(res);
    }
}
