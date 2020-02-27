package weekly_contests.weekly_137;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1047 {

    public String removeDuplicates(String str) {
        final Deque<Character> stack = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            if (!stack.isEmpty() && stack.peekFirst() == c) {
                stack.removeFirst();
            } else {
                stack.addFirst(c);
            }
        }
        final StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }

    public static String removeDuplicatesImproved(String str) {
        int i = 0;
        final char[] stack = new char[str.length()];
        for (int j = 0; j < str.length(); j++) {
            if (i > 0 && stack[i - 1] == str.charAt(j)) {
                --i;
            } else {
                stack[i++] = str.charAt(j);
            }
        }
        return new String(stack, 0, i);
    }
}
