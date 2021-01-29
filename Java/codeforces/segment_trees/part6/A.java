package codeforces.segment_trees.part6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public final class A {

    // Addition and Minimum
    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long min;
        long operation;

        SegTree(int leftMost, int rightMost) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
        }

        private static long operation(long a, long b) {
            if (b == Long.MAX_VALUE) {
                return a;
            }
            if (a == Long.MAX_VALUE) {
                return b;
            }
            return b + a;
        }

        private void propagate() {
            if (leftMost == rightMost) {
                return;
            }
            if (left == null || right == null) {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid);
                right = new SegTree(mid + 1, rightMost);
            }
            left.operation = operation(left.operation, operation);
            right.operation = operation(right.operation, operation);
            left.min = operation(left.min, operation);
            right.min = operation(right.min, operation);
            operation = Long.MAX_VALUE;
        }

        private long query(int l, int r) {
            propagate();
            if (r < leftMost || l > rightMost) {
                return Long.MAX_VALUE;
            }
            if (l <= leftMost && rightMost <= r) {
                return min;
            }
            return Math.min(left.query(l, r), right.query(l, r));
        }

        private void add(int l, int r, int v) {
            propagate();
            if (r < leftMost || l > rightMost) {
                return;
            }
            if (l <= leftMost && rightMost <= r) {
                min = operation(min, v);
                operation = operation(operation, v);
                return;
            }
            left.add(l, r, v);
            right.add(l, r, v);
            min = Math.min(left.min, right.min);
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final int q = fs.nextInt();
        final SegTree st = new SegTree(0, n - 1);
        for (int i = 0; i < q; i++) {
            final int type = fs.nextInt();
            final int l = fs.nextInt();
            final int r = fs.nextInt();
            if (type == 1) {
                st.add(l, r - 1, fs.nextInt());
            } else {
                pw.println(st.query(l, r - 1));
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
