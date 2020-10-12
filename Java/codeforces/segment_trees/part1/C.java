package codeforces.segment_trees.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public final class C {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int min, count;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                min = arr[leftMost];
                count = 1;
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
            min = Math.min(left.min, right.min);
            int newCount = 0;
            if (left.min == min) {
                newCount += left.count;
            }
            if (right.min == min) {
                newCount += right.count;
            }
            count = newCount;
        }

        private int[] query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return new int[] { Integer.MAX_VALUE, 1 };
            }
            if (l <= leftMost && rightMost <= r) {
                return new int[] { min, count };
            }
            final int[] leftRes = left.query(l, r);
            final int[] rightRes = right.query(l, r);
            final int newMin = Math.min(leftRes[0], rightRes[0]);
            int newCount = 0;
            if (leftRes[0] == newMin) {
                newCount += leftRes[1];
            }
            if (rightRes[0] == newMin) {
                newCount += rightRes[1];
            }
            return new int[] { newMin, newCount };
        }

        private void update(int idx, int val) {
            if (leftMost == rightMost) {
                min = val;
                count = 1;
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
            final int l = fs.nextInt();
            final int r = fs.nextInt();
            if (type == 1) {
                st.update(l, r);
            } else {
                final int[] query = st.query(l, r - 1);
                System.out.println(query[0] + " " + query[1]);
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
