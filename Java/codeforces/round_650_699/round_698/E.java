package codeforces.round_650_699.round_698;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long sum;
        long operation = Long.MAX_VALUE;

        SegTree(int leftMost, int rightMost, int[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                sum = arr[leftMost];
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                sum = left.sum + right.sum;
            }
        }

        private static long operation(long a, long b) {
            if (b == Long.MAX_VALUE) {
                return a;
            }
            return b;
        }

        private void propagate() {
            if (leftMost == rightMost) {
                return;
            }
            left.operation = operation(left.operation, operation);
            right.operation = operation(right.operation, operation);
            if (operation != Long.MAX_VALUE) {
                left.sum = (left.rightMost - left.leftMost + 1) * operation;
                right.sum = (right.rightMost - right.leftMost + 1) * operation;
            }
            operation = Long.MAX_VALUE;
        }

        private long query(int l, int r) {
            propagate();
            if (r < leftMost || l > rightMost) {
                return 0;
            }
            if (l <= leftMost && rightMost <= r) {
                return sum;
            }
            return left.query(l, r) + right.query(l, r);
        }

        private void add(int l, int r, long v) {
            propagate();
            if (r < leftMost || l > rightMost) {
                return;
            }
            if (l <= leftMost && rightMost <= r) {
                operation = operation(operation, v);
                sum = (rightMost - leftMost + 1) * v;
                return;
            }
            left.add(l, r, v);
            right.add(l, r, v);
            sum = left.sum + right.sum;
        }
    }

    public static void main(String[] args) {
        final PrintWriter pw = new PrintWriter(System.out);
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        outer:
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int q = fs.nextInt();
            final char[] start = fs.next().toCharArray();
            final char[] end = fs.next().toCharArray();
            final int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = end[i] - '0';
            }
            final SegTree st = new SegTree(0, n - 1, arr);
            final int[][] queries = new int[q][2];
            for (int i = 0; i < q; i++) {
                queries[i] = new int[] { fs.nextInt() - 1, fs.nextInt() - 1 };
            }
            for (int i = q - 1; i >= 0; i--) {
                final int l = queries[i][0];
                final int r = queries[i][1];
                final int range = r - l + 1;
                final long sum = st.query(l, r);
                if (sum * 2 == range) {
                    pw.println("NO");
                    continue outer;
                } else if (sum * 2 < range) {
                    st.add(l, r, 0);
                } else {
                    st.add(l, r, 1);
                }
            }
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if (st.query(i, i) != start[i] - '0') {
                    ok = false;
                    break;
                }
            }
            pw.println(ok ? "YES" : "NO");
        }
        pw.close();
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
