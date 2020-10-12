package codeforces.segment_trees.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public final class D {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int max;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                max = arr[leftMost];
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
            max = Math.max(left.max, right.max);
        }

        private int query(int k, int l) {
            if (max < k || rightMost < l) {
                return -1;
            }
            if (leftMost == rightMost) {
                return leftMost;
            }
            final int resL = left.query(k, l);
            return resL != -1 ? resL : right.query(k, l);
        }

        private void update(int idx, int val) {
            if (leftMost == rightMost) {
                max = val;
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
        final int q = fs.nextInt();
        final int[] arr = fs.nextIntArray(n);
        final SegTree st = new SegTree(0, n - 1, arr);
        for (int i = 0; i < q; i++) {
            final int type = fs.nextInt();
            if (type == 1) {
                final int l = fs.nextInt();
                final int r = fs.nextInt();
                st.update(l, r);
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
