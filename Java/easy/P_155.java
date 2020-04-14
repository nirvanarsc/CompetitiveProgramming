package easy;

import java.util.Deque;
import java.util.LinkedList;

public class P_155 {

    static class MinStack {

        Deque<Integer> stack;
        Deque<Integer> min;

        MinStack() {
            stack = new LinkedList<>();
            min = new LinkedList<>();
        }

        public void push(int x) {
            if (min.isEmpty() || min.peekFirst() >= x) {
                min.addFirst(x);
            }
            stack.addFirst(x);
        }

        public void pop() {
            if (min.element().equals(stack.removeFirst())) {
                min.removeFirst();
            }
        }

        public int top() {
            return stack.element();
        }

        public int getMin() {
            return min.element();
        }
    }
}
