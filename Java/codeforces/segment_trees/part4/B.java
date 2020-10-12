package codeforces.segment_trees.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public final class B {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int[] prod;
        int mod;

        SegTree(int leftMost, int rightMost, int[][] arr, int mod) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            this.mod = mod;
            if (leftMost == rightMost) {
                prod = arr[leftMost];
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr, mod);
                right = new SegTree(mid + 1, rightMost, arr, mod);
                recalc();
            }
        }

        private void recalc() {
            if (leftMost == rightMost) {
                return;
            }
            prod = merge(left.prod, right.prod);
        }

        private int[] query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return new int[] { 1, 0, 0, 1 };
            }
            if (l <= leftMost && rightMost <= r) {
                return prod;
            }
            return merge(left.query(l, r), right.query(l, r));
        }

        private int[] merge(int[] left, int[] right) {
            final int[] res = new int[4];
            res[0] = ((left[0] * right[0]) + (left[1] * right[2])) % mod;
            res[1] = ((left[0] * right[1]) + (left[1] * right[3])) % mod;
            res[2] = ((left[2] * right[0]) + (left[3] * right[2])) % mod;
            res[3] = ((left[2] * right[1]) + (left[3] * right[3])) % mod;
            return res;
        }
    }

    public static void main(String[] args) {
        final FastScanner sc = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int mod = sc.nextInt();
        final int n = sc.nextInt();
        final int m = sc.nextInt();
        final int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt() };
        }
        final SegTree st = new SegTree(0, n - 1, arr, mod);
        for (int i = 0; i < m; i++) {
            final int left = sc.nextInt() - 1;
            final int right = sc.nextInt() - 1;
            final int[] res = st.query(left, right);
            pw.println(res[0] + " " + res[1]);
            pw.println(res[2] + " " + res[3]);
            pw.println();
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
