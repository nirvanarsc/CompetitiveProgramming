package atcoder.acl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public final class L {

    private static class Node {
        final long count0, count1, count01, count10;

        Node(long count0, long count1, long count01, long count10) {
            this.count0 = count0;
            this.count1 = count1;
            this.count01 = count01;
            this.count10 = count10;
        }

        Node flip() {
            return new Node(count1, count0, count10, count01);
        }
    }

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        Node node;
        long operation = Long.MAX_VALUE;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                if (arr[leftMost] == 0) {
                    node = new Node(1, 0, 0, 0);
                } else {
                    node = new Node(0, 1, 0, 0);
                }
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                recalc();
            }
        }

        private void recalc() {
            if (leftMost == rightMost) {
                return;
            }
            node = merge(left.node, right.node);
        }

        private static Node merge(Node left, Node right) {
            final long count0 = left.count0 + right.count0;
            final long count1 = left.count1 + right.count1;
            final long count01 = left.count01 + right.count01 + left.count0 * right.count1;
            final long count10 = left.count10 + right.count10 + left.count1 * right.count0;
            return new Node(count0, count1, count01, count10);
        }

        private static long operation(long a, long b) {
            if (b == Long.MAX_VALUE) {
                return a;
            }
            if (a == Long.MAX_VALUE) {
                return b;
            }
            return a + b;
        }

        private void propagate() {
            if (leftMost == rightMost) {
                return;
            }
            left.operation = operation(left.operation, operation);
            right.operation = operation(right.operation, operation);
            if (operation != Long.MAX_VALUE && operation % 2 != 0) {
                left.node = left.node.flip();
                right.node = right.node.flip();
                node = merge(left.node, right.node);
            }
            operation = Long.MAX_VALUE;
        }

        private Node query(int l, int r) {
            propagate();
            if (r < leftMost || l > rightMost) {
                return new Node(0, 0, 0, 0);
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
                node = node.flip();
                return;
            }
            left.add(l, r, v);
            right.add(l, r, v);
            node = merge(left.node, right.node);
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final int q = fs.nextInt();
        final int[] arr = fs.nextIntArray(n);
        final SegTree st = new SegTree(0, n - 1, arr);
        for (int i = 0; i < q; i++) {
            final int type = fs.nextInt();
            final int l = fs.nextInt() - 1;
            final int r = fs.nextInt() - 1;
            if (type == 1) {
                st.add(l, r, 1);
            } else {
                pw.println(st.query(l, r).count10);
            }
        }
        pw.close();
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
