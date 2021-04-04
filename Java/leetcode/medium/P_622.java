package leetcode.medium;

@SuppressWarnings("unused")
public class P_622 {

    static class MyCircularQueue {

        int back;
        int front;
        int[] arr;
        int n;
        int size;

        MyCircularQueue(int k) {
            arr = new int[k];
            n = k;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            arr[back] = value;
            back = (back + 1) % n;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % n;
            size--;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return arr[front];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return arr[(back - 1 + n) % n];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == n;
        }
    }
}
