package weekly_contests.weekly_126;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1003 {

    public boolean isValid(String S) {
        final Deque<Character> stack = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
            if (c == 'c') {
                if (!stack.isEmpty() && stack.pop() != 'b') { return false; }
                if (!stack.isEmpty() && stack.pop() != 'a') { return false; }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
