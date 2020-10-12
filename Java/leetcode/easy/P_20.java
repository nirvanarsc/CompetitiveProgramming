package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P_20 {

    public boolean isValid(String s) {
        final Deque<Character> stack = new ArrayDeque<>();
        final Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                if (stack.isEmpty() || map.get(stack.peekFirst()) != c) {
                    return false;
                }
                stack.removeFirst();
            } else {
                stack.addFirst(c);
            }
        }
        return stack.isEmpty();
    }
}
