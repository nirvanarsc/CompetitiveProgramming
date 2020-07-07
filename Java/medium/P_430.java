package medium;

public class P_430 {

    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    Node prev;

    public Node flatten(Node head) {
        traverse(head);
        return head;
    }

    @SuppressWarnings("ConstantConditions")
    private void traverse(Node head) {
        if (head == null) {
            return;
        }
        if (prev != null) {
            head.prev = prev;
            prev.next = head;
        }
        prev = head;
        final Node next = head.next;
        traverse(head.child);
        head.child = null;
        traverse(next);
    }
}
