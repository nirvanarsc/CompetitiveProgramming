package utils;

public class DataStructures {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) { val = x; }
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) { val = x; }

        public static void printList(ListNode head) {
            while (head != null) {
                System.out.print(head.val + (head.next == null ? "" : "->"));
                head = head.next;
            }
            System.out.println();
        }

        public static ListNode testList(int num) {
            ListNode a = new ListNode(1);
            final ListNode head = a;
            for (int i = 1; i <= num; i++) {
                a.next = new ListNode(i);
                a = a.next;
            }
            return head;
        }
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
