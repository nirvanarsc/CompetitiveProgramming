package codeforces.round_650_699.round_694;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    // RMQ index
    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int min;
        int idx;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                min = arr[leftMost];
                idx = leftMost;
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
            if (left.min < right.min) {
                min = left.min;
                idx = left.idx;
            } else {
                min = right.min;
                idx = right.idx;
            }
        }

        private int[] query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return new int[] { (int) 2e9, -1 };
            }
            if (l <= leftMost && rightMost <= r) {
                return new int[] { min, idx };
            }
            final int[] ll = left.query(l, r);
            final int[] rr = right.query(l, r);
            if (ll[0] < rr[0]) {
                return ll;
            }
            return rr;
        }

        private void update(int idx, int val) {
            if (leftMost == rightMost) {
                min = val;
                this.idx = leftMost;
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
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int m = fs.nextInt();
            final int[] arr = fs.nextIntArray(n);
            final int[] present = fs.nextIntArray(m);
            long res = 0;
            final SegTree st = new SegTree(0, m - 1, present);
            Utils.shuffleSort(arr);
            for (int i = n - 1; i >= 0; i--) {
                final int[] query = st.query(0, arr[i] - 1);
                final int ll = query[0];
                final int rr = present[arr[i] - 1];
                if (ll == (int) 2e9) {
                    res += rr;
                } else {
                    if (ll < rr) {
                        res += ll;
                        st.update(query[1], (int) 2e9);
                    } else {
                        res += rr;
                    }
                }
            }
            System.out.println(res);
        }
    }

    static final class Utils {
        public static void shuffleSort(int[] x) {
            shuffle(x);
            Arrays.sort(x);
        }

        public static void shuffleSort(long[] x) {
            shuffle(x);
            Arrays.sort(x);
        }

        public static void shuffle(int[] x) {
            final Random r = new Random();

            for (int i = 0; i <= x.length - 2; i++) {
                final int j = i + r.nextInt(x.length - i);
                swap(x, i, j);
            }
        }

        public static void shuffle(long[] x) {
            final Random r = new Random();

            for (int i = 0; i <= x.length - 2; i++) {
                final int j = i + r.nextInt(x.length - i);
                swap(x, i, j);
            }
        }

        public static void swap(int[] x, int i, int j) {
            final int t = x[i];
            x[i] = x[j];
            x[j] = t;
        }

        public static void swap(long[] x, int i, int j) {
            final long t = x[i];
            x[i] = x[j];
            x[j] = t;
        }

        private Utils() {}
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
