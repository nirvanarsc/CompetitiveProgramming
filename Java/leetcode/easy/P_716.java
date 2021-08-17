package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("unused")
public class P_716 {

    static class MaxStack {
        Deque<Integer> stack;
        Deque<Integer> maxStack;

        MaxStack() {
            stack = new ArrayDeque<>();
            maxStack = new ArrayDeque<>();
        }

        public void push(int x) {
            if (maxStack.isEmpty() || x >= maxStack.getFirst()) {
                maxStack.addFirst(x);
            }
            stack.push(x);
        }

        public int pop() {
            if (maxStack.getFirst().equals(stack.getFirst())) {
                maxStack.removeFirst();
            }
            return stack.removeFirst();
        }

        public int peek() {
            return stack.getFirst();
        }

        public int peekMax() {
            return maxStack.getFirst();
        }
    }
}
