package medium;

import utils.DataStructures.ListNode;

public final class P_86 {

    public static ListNode partition(ListNode head, int x) {
        ListNode smallerTail = new ListNode(-1), greaterTail = new ListNode(-1);
        final ListNode smallerHead = smallerTail;
        final ListNode greaterHead = greaterTail;
        while (head != null) {
            if (head.val < x) {
                smallerTail.next = head;
                smallerTail = smallerTail.next;
            } else {
                greaterTail.next = head;
                greaterTail = greaterTail.next;
            }
            head = head.next;
        }
        greaterTail.next = null;
        smallerTail.next = greaterHead.next;
        return smallerHead.next;
    }

    public static void main(String[] args) {
        partition(ListNode.testList(10), 3);
    }

    private P_86() {}
}
