package leetcode.medium;

public class P_138 {

    private static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    public Node copyRandomList(Node head) {
        Node iter = head, next;

        while (iter != null) {
            next = iter.next;

            final Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        iter = head;
        final Node pseudoHead = new Node(0);
        Node copy, copyIter = pseudoHead;

        while (iter != null) {
            next = iter.next.next;

            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            iter.next = next;
            iter = next;
        }

        return pseudoHead.next;
    }
}
