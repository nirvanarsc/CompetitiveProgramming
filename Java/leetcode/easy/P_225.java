package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings({ "unused", "InnerClassMayBeStatic", "PublicConstructorInNonPublicClass" })
public class P_225 {

    class MyStack {

        Deque<Integer> dq;

        public MyStack() {
            dq = new ArrayDeque<>();
        }

        public void push(int x) {
            dq.addFirst(x);
        }

        public int pop() {
            return dq.removeFirst();
        }

        public int top() {
            return dq.getFirst();
        }

        public boolean empty() {
            return dq.isEmpty();
        }
    }
}
