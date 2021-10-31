package leetcode.medium;

@SuppressWarnings("ConstantConditions")
public class P_430 {

    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    static Node prev;

    public Node flatten(Node head) {
        prev = null;
        dfs(head);
        return head;
    }

    private static void dfs(Node curr) {
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
