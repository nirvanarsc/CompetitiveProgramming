package leetcode.weekly_contests.weekly_5;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_402 {

    public String removeKdigits(String num, int k) {
        final StringBuilder sb = new StringBuilder();
        final Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peekFirst() > num.charAt(i)) {
                stack.removeFirst();
                k--;
            }
            stack.addFirst(num.charAt(i));
        }
        while (k > 0) {
            stack.removeFirst();
            k--;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
