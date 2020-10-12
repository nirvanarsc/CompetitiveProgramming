package leetcode.weekly_contests.weekly_180;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1381 {

    static class CustomStack {
        int size;
        Deque<Integer> stack;

        CustomStack(int maxSize) {
            stack = new ArrayDeque<>(maxSize);
            size = maxSize;
        }

        public void push(int x) {
            if (stack.size() < size) {
                stack.addFirst(x);
            }
        }

        public int pop() {
            return stack.isEmpty() ? -1 : stack.removeFirst();
        }

        public void increment(int k, int val) {
            final Deque<Integer> temp = new ArrayDeque<>();
            final int size = stack.size();
            for (int i = 0; i < Math.min(k, size); i++) {
                temp.addFirst(stack.removeLast() + val);
            }
            while (!temp.isEmpty()) {
                stack.addLast(temp.removeFirst());
            }
        }
    }
}
