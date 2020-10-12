package codeforces.segment_trees.part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public final class A {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long val;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                val = arr[leftMost];
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
            }
        }

        private void add(int l, int r, int v) {
            if (r < leftMost || l > rightMost) {
                return;
            }
            if (l <= leftMost && rightMost <= r) {
                val += v;
                return;
            }
            left.add(l, r, v);
            right.add(l, r, v);
        }

        private long get(int idx) {
            if (leftMost == rightMost) {
                return val;
            }
            final int mid = leftMost + rightMost >>> 1;
            if (idx <= mid) {
                return val + left.get(idx);
            } else {
                return val + right.get(idx);
            }
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final int q = fs.nextInt();
        final SegTree st = new SegTree(0, n - 1, new int[n]);
        for (int i = 0; i < q; i++) {
            final int type = fs.nextInt();
            if (type == 1) {
                final int l = fs.nextInt();
                final int r = fs.nextInt();
                final int v = fs.nextInt();
                st.add(l, r - 1, v);
            } else {
                pw.println(st.get(fs.nextInt()));
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
