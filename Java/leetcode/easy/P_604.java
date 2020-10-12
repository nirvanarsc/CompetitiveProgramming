package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_604 {

    static class Pair {
        char c;
        int count;

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    static class StringIterator {

        Deque<Pair> stack = new ArrayDeque<>();

        StringIterator(String compressedString) {
            int i = 0;
            while (i < compressedString.length()) {
                final char c = compressedString.charAt(i);
                i++;
                int countEnd = i;
                while (countEnd < compressedString.length()
                       && Character.isDigit(compressedString.charAt(countEnd))) {
                    countEnd++;
                }
                stack.addLast(new Pair(c, Integer.parseInt(compressedString.substring(i, countEnd))));
                i = countEnd;
            }
        }

        public char next() {
            if (!stack.isEmpty()) {
                if (stack.peekFirst().count == 1) {
                    return stack.removeFirst().c;
                }
                stack.peekFirst().count--;
                return stack.peekFirst().c;
            } else {
                return ' ';
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
