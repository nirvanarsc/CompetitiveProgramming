package codeforces.segment_trees.part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public final class C {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long max;
        long operation;

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
            left.max = operation(left.max, operation);
            right.max = operation(right.max, operation);
            operation = Long.MAX_VALUE;
        }

        private int query(int k, int l) {
            propagate();
            if (max < k || rightMost < l) {
                return -1;
            }
            if (leftMost == rightMost) {
                return leftMost;
            }
            final int resL = left.query(k, l);
            return resL != -1 ? resL : right.query(k, l);
        }

        private void add(int l, int r, long v) {
            propagate();
            if (r < leftMost || l > rightMost) {
                return;
            }
            if (l <= leftMost && rightMost <= r) {
                max = operation(max, v);
                operation = operation(operation, v);
                return;
            }
            left.add(l, r, v);
            right.add(l, r, v);
            max = Math.max(left.max, right.max);
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int q = fs.nextInt();
        final SegTree st = new SegTree(0, n - 1);
        for (int i = 0; i < q; i++) {
            final int type = fs.nextInt();
            if (type == 1) {
                final int l = fs.nextInt();
                final int r = fs.nextInt();
                final int v = fs.nextInt();
                st.add(l, r - 1, v);
            } else {
                final int k = fs.nextInt();
                final int l = fs.nextInt();
                System.out.println(st.query(k, l));
            }
        }
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
