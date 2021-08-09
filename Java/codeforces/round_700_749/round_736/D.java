package codeforces.round_700_749.round_736;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long gcd;

        SegTree(int leftMost, int rightMost, long[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                gcd = arr[leftMost];
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                recalc();
            }
        }

        private void recalc() {
            gcd = gcd(left.gcd, right.gcd);
        }

        private long query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return gcd;
            }
            return gcd(left.query(l, r), right.query(l, r));
        }

        private void update(int idx, long val) {
            if (leftMost == rightMost) {
                gcd = val;
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

        private static long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final StringBuilder sb = new StringBuilder();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            int n = fs.nextInt();
            final long[] arr = fs.nextLongArray(n);
            if (n == 1) {
                sb.append(1).append('\n');
                continue;
            }
            n--;
            final long[] diff = new long[n];
            for (int i = 0; i < n; i++) {
                diff[i] = Math.abs(arr[i] - arr[i + 1]);
            }
            final SegTree st = new SegTree(0, n - 1, diff);
            int res = 0;
            int j = 0;
            long gcd = 0;
            for (int i = 0; i < n; i++) {
                gcd = SegTree.gcd(gcd, diff[i]);
                while (gcd == 1) {
                    gcd = st.query(++j, i);
                }
                if (gcd > 1) {
                    res = Math.max(res, i - j + 1);
                }
            }
            sb.append(res + 1).append('\n');
        }
        System.out.println(sb);
    }

    static final class Utils {
        private static class Shuffler {
            private static void shuffle(int[] x) {
                final Random r = new Random();

                for (int i = 0; i <= x.length - 2; i++) {
                    final int j = i + r.nextInt(x.length - i);
                    swap(x, i, j);
                }
            }

            private static void shuffle(long[] x) {
                final Random r = new Random();

                for (int i = 0; i <= x.length - 2; i++) {
                    final int j = i + r.nextInt(x.length - i);
                    swap(x, i, j);
                }
            }

            private static void swap(int[] x, int i, int j) {
                final int t = x[i];
                x[i] = x[j];
                x[j] = t;
            }

            private static void swap(long[] x, int i, int j) {
                final long t = x[i];
                x[i] = x[j];
                x[j] = t;
            }
        }

        public static void shuffleSort(int[] arr) {
            Shuffler.shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffleSort(long[] arr) {
            Shuffler.shuffle(arr);
            Arrays.sort(arr);
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
