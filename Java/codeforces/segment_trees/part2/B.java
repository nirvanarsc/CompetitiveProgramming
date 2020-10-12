package codeforces.segment_trees.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("TailRecursion")
public final class B {

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

        private long query(int k) {
            if (leftMost == rightMost) {
                return leftMost;
            }
            if (left.sum <= k) {
                return right.query(k - left.sum);
            }
            return left.query(k);
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
        final int q = fs.nextInt();
        final int[] arr = fs.nextIntArray(n);
        final SegTree st = new SegTree(0, n - 1, arr);
        for (int i = 0; i < q; i++) {
            final int type = fs.nextInt();
            final int index = fs.nextInt();
            if (type == 1) {
                arr[index] ^= 1;
                st.update(index, arr[index]);
            } else {
                System.out.println(st.query(index));
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
