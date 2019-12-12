package medium;

import utils.DataStructures.ListNode;

public final class P_61 {

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        final ListNode newHead;
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        tail.next = head;
        k %= length;
        for (int i = 0; i < length - k; i++) {
            tail = tail.next;
        }
        newHead = tail.next;
        tail.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode.printList(rotateRight(ListNode.testList(9), 3));
    }

    private P_61() {}
}
