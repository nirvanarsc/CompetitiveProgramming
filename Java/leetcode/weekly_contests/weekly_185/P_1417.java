package leetcode.weekly_contests.weekly_185;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1417 {

    public String reformat(String s) {
        final Deque<Character> chars = new ArrayDeque<>();
        final Deque<Character> ints = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                ints.addFirst(c);
            } else {
                chars.addFirst(c);
            }
        }
        if (Math.abs(chars.size() - ints.size()) > 1) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        boolean charFirst = chars.size() > ints.size();
        while (!chars.isEmpty() && !ints.isEmpty()) {
            if (charFirst) {
                sb.append(chars.removeLast());
            } else {
                sb.append(ints.removeLast());
            }
            charFirst ^= true;
        }
        return sb.toString();
    }
}
