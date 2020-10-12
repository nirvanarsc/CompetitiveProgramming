package codeforces.segment_trees.part6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public final class B {

    private static final int MOD = (int) (1e9 + 7);

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long sum;
        long operation = 1;

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
            sum = (((left.sum + right.sum) % MOD) * operation) % MOD;
        }

        private long query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return sum;
            }
            return (((left.query(l, r) + right.query(l, r)) % MOD) * operation) % MOD;
        }

        private void add(int l, int r, int v) {
            if (r < leftMost || l > rightMost) {
                return;
            }
            if (l <= leftMost && rightMost <= r) {
                sum = (sum * v) % MOD;
                operation = (operation * v) % MOD;
                return;
            }
            left.add(l, r, v);
            right.add(l, r, v);
            recalc();
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final int q = fs.nextInt();
        final int[] arr = new int[n];
        Arrays.fill(arr, 1);
        final SegTree st = new SegTree(0, n - 1, arr);
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
