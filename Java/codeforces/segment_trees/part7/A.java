package codeforces.segment_trees.part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public final class A {

    private static class Node {
        long sum;
        long prefix = (long) -1e9;
        long suffix = (long) -1e9;
        long res = (long) -1e9;
    }

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long operation;
        Node node = new Node();

        SegTree(int leftMost, int rightMost) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost != rightMost) {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid);
                right = new SegTree(mid + 1, rightMost);
            }
        }

        private static long operation(long a, long b) {
            if (b == Long.MAX_VALUE) {
                return a;
            }
            return b;
        }

        private void propagate() {
            if (leftMost == rightMost) {
                return;
            }
            left.operation = operation(left.operation, operation);
            right.operation = operation(right.operation, operation);
            if (operation != Long.MAX_VALUE) {
                final int ll = left.rightMost - left.leftMost + 1;
                final int rr = right.rightMost - right.leftMost + 1;
                left.node.sum = ll * operation;
                left.node.prefix = left.node.suffix = Math.max(operation, ll * operation);
                left.node.res = Math.max(0, ll * operation);
                right.node.sum = rr * operation;
                right.node.prefix = right.node.suffix = Math.max(operation, rr * operation);
                right.node.res = Math.max(0, rr * operation);
            }
            operation = Long.MAX_VALUE;
        }

        private Node query(int l, int r) {
            propagate();
            if (r < leftMost || l > rightMost) {
                return new Node();
            }
            if (l <= leftMost && rightMost <= r) {
                return node;
            }
            return merge(left.query(l, r), right.query(l, r));
        }

        private void add(int l, int r, int v) {
            propagate();
            if (r < leftMost || l > rightMost) {
                return;
            }
            if (l <= leftMost && rightMost <= r) {
                operation = v;
                node.sum = (rightMost - leftMost + 1) * operation;
                node.res = Math.max(0, (rightMost - leftMost + 1) * operation);
                node.prefix = node.suffix = Math.max(operation, (rightMost - leftMost + 1) * operation);
                return;
            }
            left.add(l, r, v);
            right.add(l, r, v);
            node = merge(left.node, right.node);
        }

        private static Node merge(Node leftNode, Node rightNode) {
            final Node res = new Node();
            res.sum = leftNode.sum + rightNode.sum;
            res.prefix = Math.max(leftNode.sum + rightNode.prefix, leftNode.prefix);
            res.suffix = Math.max(rightNode.sum + leftNode.suffix, rightNode.suffix);
            res.res = Math.max(Math.max(leftNode.res, rightNode.res), leftNode.suffix + rightNode.prefix);
            return res;
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final int q = fs.nextInt();
        final SegTree st = new SegTree(0, n - 1);
        for (int i = 0; i < q; i++) {
            final int l = fs.nextInt();
            final int r = fs.nextInt();
            final int v = fs.nextInt();
            st.add(l, r - 1, v);
            pw.println(st.query(0, n - 1).res);
        }
        pw.flush();
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        private String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    //noinspection CallToPrintStackTrace
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        int[] nextIntArray(int n) {
            final int[] a = new int[n];
            for (int i = 0; i < n; i++) { a[i] = nextInt(); }
            return a;
        }

        long[] nextLongArray(int n) {
            final long[] a = new long[n];
            for (int i = 0; i < n; i++) { a[i] = nextLong(); }
            return a;
        }
    }
}
