package codeforces.segment_trees.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public final class D {

    static class Node {
        boolean[] seen = new boolean[40];
        int count;
    }

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        Node node = new Node();

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                node.seen[arr[leftMost] - 1] = true;
                node.count++;
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                node = merge(left.node, right.node);
            }
        }

        private static Node merge(Node l, Node r) {
            final Node res = new Node();
            int count = 0;
            for (int i = 0; i < 40; i++) {
                res.seen[i] = l.seen[i] || r.seen[i];
                count += res.seen[i] ? 1 : 0;
            }
            res.count = count;
            return res;
        }

        private Node query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return new Node();
            }
            if (l <= leftMost && rightMost <= r) {
                return node;
            }
            return merge(left.query(l, r), right.query(l, r));
        }

        private void update(int idx, int newVal) {
            if (leftMost == rightMost) {
                node = new Node();
                node.seen[newVal - 1] = true;
                node.count++;
            } else {
                final int mid = leftMost + rightMost >>> 1;
                if (idx <= mid) {
                    left.update(idx, newVal);
                } else {
                    right.update(idx, newVal);
                }
                node = merge(left.node, right.node);
            }
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
            if (type == 1) {
                final int l = fs.nextInt() - 1;
                final int r = fs.nextInt() - 1;
                pw.println(st.query(l, r).count);
            } else {
                final int idx = fs.nextInt() - 1;
                final int val = fs.nextInt();
                st.update(idx, val);
            }
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
