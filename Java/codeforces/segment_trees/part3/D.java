package codeforces.segment_trees.part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public final class D {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int sum;

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

        private int query(int l, int r) {
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
        final int[] arr = fs.nextIntArray(2 * n);
        final int[] res = new int[n];
        solve(n, arr, res);
        final int[] rev = new int[2 * n];
        for (int i = 2 * n - 1, j = 0; i >= 0; i--, j++) {
            rev[j] = arr[i];
        }
        solve(n, rev, res);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    private static void solve(int n, int[] arr, int[] res) {
        final SegTree st = new SegTree(0, 2 * n - 1, new int[2 * n]);
        final Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < 2 * n; i++) {
            if (indices.containsKey(arr[i])) {
                st.update(indices.get(arr[i]), 0);
                res[arr[i] - 1] += st.query(indices.get(arr[i]), i);
            } else {
                st.update(i, 1);
                indices.put(arr[i], i);
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
