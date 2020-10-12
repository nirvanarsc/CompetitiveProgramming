package leetcode.medium;

public class P_430 {

    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    Node prev;

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    @SuppressWarnings("ConstantConditions")
    private void dfs(Node curr) {
        if (curr == null) {
            return;
        }
        if (prev != null) {
            curr.prev = prev;
            prev.next = curr;
        }
        prev = curr;
        final Node next = curr.next;
        final Node child = curr.child;
        curr.child = null;
        dfs(child);
        dfs(next);
    }
}
