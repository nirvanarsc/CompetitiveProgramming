package easy;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class P_716 {

    static class MaxStack {

        Deque<Integer> stack;
        PriorityQueue<Integer> pqMax;

        MaxStack() {
            stack = new ArrayDeque<>();
            pqMax = new PriorityQueue<>(Comparator.reverseOrder());
        }

        public void push(int x) {
            stack.addFirst(x);
            pqMax.add(x);
        }

        public int pop() {
            final int deleteE = stack.removeFirst();
            pqMax.remove(deleteE);
            return deleteE;
        }

        public int top() {
            return stack.getFirst();
        }

        public int peekMax() {
            return pqMax.element();
        }

        public int popMax() {
            final int deleteE = pqMax.remove();
            stack.removeFirstOccurrence(deleteE);
            return deleteE;
        }
    }
}
