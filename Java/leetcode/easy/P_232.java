package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("unused")
public class P_232 {

    static class MyQueue {

        Deque<Integer> s1;
        Deque<Integer> s2;
        int front;

        MyQueue() {
            s1 = new ArrayDeque<>();
            s2 = new ArrayDeque<>();
        }

        public void push(int x) {
            if (s1.isEmpty()) {
                front = x;
            }
            s1.addFirst(x);
        }

        public int pop() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.addFirst(s1.removeFirst());
                }
            }
            return s2.removeFirst();
        }

        public int peek() {
            return s2.isEmpty() ? front : s2.getFirst();
        }

        public boolean empty() {
            return s1.size() + s2.size() == 0;
        }
    }
}
