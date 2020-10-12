package leetcode.medium;

@SuppressWarnings("unused")
public class P_707 {

    static class ListNode {
        ListNode next;
        ListNode prev;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }

    static class MyLinkedList {
        ListNode head, tail;
        int size;

        MyLinkedList() {
            head = new ListNode(-1);
            tail = new ListNode(-1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            if (index >= size) {
                return -1;
            }
            ListNode iter = head;
            for (int i = 0; i <= index; i++) {
                iter = iter.next;
            }
            return iter.val;
        }

        public void addAtHead(int val) {
            final ListNode newNode = new ListNode(val);
            head.next.prev = newNode;
            newNode.next = head.next;
            newNode.prev = head;
            head.next = newNode;
            size++;
        }

        public void addAtTail(int val) {
            final ListNode newNode = new ListNode(val);
            tail.prev.next = newNode;
            newNode.prev = tail.prev;
            newNode.next = tail;
            tail.prev = newNode;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index == size) {
                addAtTail(val);
                return;
            }
            ListNode iter = head;
            for (int i = 0; i <= index; i++) {
                iter = iter.next;
            }
            final ListNode newNode = new ListNode(val);
            iter.prev.next = newNode;
            newNode.prev = iter.prev;
            newNode.next = iter;
            iter.prev = newNode;
            size++;
        }

        @SuppressWarnings("ConstantConditions")
        public void deleteAtIndex(int index) {
            if (index >= size) {
                return;
            }
            ListNode iter = head;
            for (int i = 0; i <= index; i++) {
                iter = iter.next;
            }
            iter.prev.next = iter.next;
            iter.next.prev = iter.prev;
            iter.prev = null;
            iter.next = null;
            size--;
        }
    }
}
