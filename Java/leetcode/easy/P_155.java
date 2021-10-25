package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings({ "InnerClassMayBeStatic", "PublicConstructorInNonPublicClass", "unused" })
public class P_155 {

    class MinStack {

        Deque<Integer> dq, min;

        public MinStack() {
            dq = new ArrayDeque<>();
            min = new ArrayDeque<>();
        }

        public void push(int val) {
            if (min.isEmpty() || min.peekFirst() >= val) {
                min.addFirst(val);
            }
            dq.addFirst(val);
        }

        public void pop() {
            if (min.element().equals(dq.removeFirst())) {
                min.removeFirst();
            }
        }

        public int top() {
            return dq.element();
        }

        public int getMin() {
            return min.element();
        }
    }
}
