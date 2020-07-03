package medium;

public class P_708 {

    static class Node {
        public int val;
        public Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            final Node res = new Node(insertVal);
            res.next = res;
            return res;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != head) {
            if (insertVal == prev.val
                || (prev.val < insertVal && insertVal < curr.val)
                || (isEnd(prev, curr) && (prev.val < insertVal || insertVal < curr.val))) {
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        final Node node = new Node(insertVal);
        prev.next = node;
        node.next = curr;
        return head;
    }

    private static boolean isEnd(Node prev, Node curr) {
        return curr.val < prev.val;
    }
}
