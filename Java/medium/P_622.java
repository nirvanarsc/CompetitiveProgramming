package medium;

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
            if(size == 0) {
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
}
