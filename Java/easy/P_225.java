package easy;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("unused")
public class P_225 {

    static class MyStack {

        Deque<Integer> q1;

        MyStack() {
            q1 = new ArrayDeque<>();
        }

        public void push(int x) {
            q1.offerLast(x);
            for (int size = q1.size(); size > 1; size--) {
                q1.offerLast(q1.removeFirst());
            }
        }

        public int pop() {
            return q1.removeFirst();
        }

        public int top() {
            return q1.getFirst();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }
}
