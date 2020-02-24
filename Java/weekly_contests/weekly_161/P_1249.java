package weekly_contests.weekly_161;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class P_1249 {

    public String minRemoveToMakeValidStack(String s) {
        final Set<Integer> indexesToRemove = new HashSet<>();
        final Deque<Integer> stack = new ArrayDeque<>();
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { stack.addFirst(i); }
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) { indexesToRemove.add(i); } else { stack.removeFirst(); }
            }
        }
        while (!stack.isEmpty()) {
            indexesToRemove.add(stack.removeFirst());
        }
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public String minRemoveToMakeValid(String s) {
        final StringBuilder sb = new StringBuilder();
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == ')' && open == 0) { continue; }
            if (c == ')' && open > 0) {
                sb.append(')');
                open--;
            } else if (c == '(') {
                sb.append('(');
                open++;
            } else {
                sb.append(c);
            }
        }
        // lastIndexOf = O(n) - solution becomes O(n^2)
        while (open > 0) {
            sb.deleteCharAt(sb.lastIndexOf("("));
            open--;
        }
        return sb.toString();
    }
}
