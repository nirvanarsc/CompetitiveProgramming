package medium;

@SuppressWarnings("unused")
public class P_641 {

    static class MyCircularDeque {

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

        MyCircularDeque(int k) {
            front = new ListNode(-1);
            rear = new ListNode(-1);
            front.next = rear;
            rear.prev = front;
            cap = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            final ListNode t = front.next;
            final ListNode newFront = new ListNode(value);
            t.prev = newFront;
            newFront.next = t;
            newFront.prev = front;
            front.next = newFront;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
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

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            final ListNode t = front.next.next;
            t.prev = front;
            front.next = t;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            final ListNode t = rear.prev.prev;
            t.next = rear;
            rear.prev = t;
            size--;
            return true;
        }

        public int getFront() {
            return front.next.val;
        }

        public int getRear() {
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
