package utils;

public class DataStructures {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) { val = x; }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
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

    public static class SegmentTree {
        int[] arr;
        int[] tree;
        int n;
        int maxSize = (int) 1e5;

        public SegmentTree(int[] arr) {
            this.arr = arr;
            n = arr.length;
            tree = new int[maxSize << 1];
            build(0, n - 1, 0);
        }

        public int query(int left, int right) {
            return query(0, n - 1, left, right, 0);
        }

        public void update(int index, int value) {
            update(0, n - 1, index, value, 0);
        }

        private int build(int left, int right, int node) {
            if (left == right) {
                tree[node] = arr[left];
                return arr[left];
            }
            final int mid = left + right >>> 1;
            tree[node] = Math.min(build(left, mid, node * 2 + 1),
                                  build(mid + 1, right, node * 2 + 2));
            return tree[node];
        }

        private void update(int left, int right, int index, int value, int node) {
            if (left == right) {
                arr[index] = value;
                tree[node] = value;
            } else {
                final int mid = left + right >>> 1;
                if (left <= index && index <= mid) {
                    update(left, mid, index, value, 2 * node + 1);
                } else {
                    update(mid + 1, right, index, value, 2 * node + 2);
                }
                tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
            }
        }

        private int query(int start, int end, int l, int r, int node) {
            if (l <= start && r >= end) {
                return tree[node];
            }
            if (end < l || start > r) {
                return Integer.MAX_VALUE;
            }
            final int mid = start + end >>> 1;
            return Math.min(query(start, mid, l, r, 2 * node + 1),
                            query(mid + 1, end, l, r, 2 * node + 2));
        }
    }
}
