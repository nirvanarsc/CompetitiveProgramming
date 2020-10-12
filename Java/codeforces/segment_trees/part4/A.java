package codeforces.segment_trees.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public final class A {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long sum;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                sum = arr[leftMost];
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
            sum = left.sum + right.sum;
        }

        private long query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return sum;
            }
            return left.query(l, r) + right.query(l, r);
        }

        private void update(int idx, int val) {
            if (leftMost == rightMost) {
                sum = val;
            } else {
                final int mid = leftMost + rightMost >>> 1;
                if (idx <= mid) {
                    left.update(idx, val);
                } else {
                    right.update(idx, val);
                }
                recalc();
            }
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[] arr = fs.nextIntArray(n);
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] = -arr[i];
            }
        }
        final SegTree st = new SegTree(0, n - 1, arr);
        final int q = fs.nextInt();
        for (int i = 0; i < q; i++) {
            final int type = fs.nextInt();
            if (type == 0) {
                final int idx = fs.nextInt() - 1;
                int val = fs.nextInt();
                if (idx % 2 == 0) {
                    val = -val;
                }
                st.update(idx, val);
            } else {
                final int l = fs.nextInt() - 1;
                final int r = fs.nextInt() - 1;
                final long res = st.query(l, r);
                System.out.println(l % 2 == 0 ? -res : res);
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
