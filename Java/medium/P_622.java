package medium;

import java.util.Arrays;

@SuppressWarnings("unused")
public class P_622 {

    static class MyCircularQueue {

        static class ListNode {
            ListNode next;
            ListNode prev;
            int val;

            ListNode(int val) {
                this.val = val;
            }
        }

        ListNode front;
        ListNode rear;
        int size;
        int cap;

        MyCircularQueue(int k) {
            front = new ListNode(-1);
            rear = new ListNode(-1);
            front.next = rear;
            rear.prev = front;
            cap = k;
        }

        public boolean enQueue(int value) {
            if (size == cap) {
                return false;
            }
            final ListNode t = rear.prev;
            final ListNode newRear = new ListNode(value);
            t.next = newRear;
            newRear.prev = t;
            newRear.next = rear;
            rear.prev = newRear;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (size == 0) {
                return false;
            }
            final ListNode t = front.next.next;
            t.prev = front;
            front.next = t;
            size--;
            return true;
        }

        public int Front() {
            return front.next.val;
        }

        public int Rear() {
            return rear.prev.val;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == cap;
        }
    }

    static class MyCircularQueueArray {
        int[] q;
        int head;
        int tail;
        int size;

        MyCircularQueueArray(int capacity) {
            head = 0;
            tail = -1;
            q = new int[capacity];
            Arrays.fill(q, -1);
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            tail = (tail + 1) % q.length;
            q[tail] = value;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            q[head] = -1;
            head = (head + 1) % q.length;
            size--;
            return true;
        }

        public int Front() {
            return q[head];
        }

        public int Rear() {
            return q[tail];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == q.length;
        }
    }
}
