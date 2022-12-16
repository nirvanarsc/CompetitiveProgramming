package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings({ "InnerClassMayBeStatic", "PublicConstructorInNonPublicClass", "unused" })
public class P_232 {

    class MyQueue {

        private final Deque<Integer> dq1;
        private final Deque<Integer> dq2;
        private int front = -1;

        public MyQueue() {
            dq1 = new ArrayDeque<>();
            dq2 = new ArrayDeque<>();
        }

        public void push(int x) {
            if (dq1.isEmpty()) {
                front = x;
            }
            dq1.addFirst(x);
        }

        public int pop() {
            if (dq2.isEmpty()) {
                while (!dq1.isEmpty()) {
                    dq2.addFirst(dq1.removeFirst());
                }
            }
            return dq2.removeFirst();
        }

        public int peek() {
            return dq2.isEmpty() ? front : dq2.getFirst();
        }

        public boolean empty() {
            return dq1.size() + dq2.size() == 0;
        }
    }
}
