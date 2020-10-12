package codeforces.segment_trees.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public final class A {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long sum, prefix, suffix, res;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                sum = prefix = suffix = arr[leftMost];
                res = Math.max(0, arr[leftMost]);
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
            prefix = Math.max(left.sum + right.prefix, left.prefix);
            suffix = Math.max(right.sum + left.suffix, right.suffix);
            res = Math.max(Math.max(left.res, right.res), left.suffix + right.prefix);
        }

        private long[] query(int l, int r) {
            final long v = (long) -1e9;
            if (r < leftMost || l > rightMost) {
                return new long[] { 0, v, v, v };
            }
            if (l <= leftMost && rightMost <= r) {
                return new long[] { sum, res, prefix, suffix };
            }
            final long[] leftRes = left.query(l, r);
            final long[] rightRes = right.query(l, r);
            final long newSum = leftRes[0] + leftRes[0];
            final long newPrefix = Math.max(leftRes[0] + rightRes[2], leftRes[2]);
            final long newSuffix = Math.max(rightRes[0] + leftRes[3], rightRes[3]);
            final long newRes = Math.max(Math.max(leftRes[1], rightRes[1]), leftRes[3] + rightRes[2]);
            return new long[] { newSum, newRes, newPrefix, newSuffix };
        }

        private void update(int idx, int val) {
            if (leftMost == rightMost) {
                sum = prefix = suffix = val;
                res = Math.max(0, val);
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
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final int q = fs.nextInt();
        final int[] arr = fs.nextIntArray(n);
        final SegTree st = new SegTree(0, n - 1, arr);
        pw.println(st.query(0, n - 1)[1]);
        for (int i = 0; i < q; i++) {
            final int l = fs.nextInt();
            final int r = fs.nextInt();
            st.update(l, r);
            pw.println(st.query(0, n - 1)[1]);
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
