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

    public static class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int p) {
            // path compression
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            final int rootP = find(p);
            final int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            // union by size
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public int count() { return count; }

        public int[] size() { return size; }
    }

    public static class BIT {
        private final int[] bit;

        public BIT(int n) {
            bit = new int[n + 1];
        }

        public void add(int i, int val) {
            while (i < bit.length) {
                bit[i] += val;
                i += lsb(i);
            }
        }

        public int query(int i) {
            int ans = 0;
            while (i > 0) {
                ans += bit[i];
                i -= lsb(i);
            }
            return ans;
        }

        private static int lsb(int i) {
            return i & -i;  // zeroes all the bits except the least significant one
        }
    }
}
