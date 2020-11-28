package codeforces.round_650_699.round_684;

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
        int operation = Integer.MAX_VALUE;

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

        private void propagate(int[] arr) {
            if (leftMost == rightMost) {
                return;
            }
            if (operation != Integer.MAX_VALUE) {
                left.operation = operation;
                right.operation = operation;
                arr[leftMost] = arr[rightMost] = operation;
                left.sum = (long) (left.rightMost - left.leftMost + 1) * operation;
                right.sum = (long) (right.rightMost - right.leftMost + 1) * operation;
                operation = Integer.MAX_VALUE;
            }
        }

        private long query(int i, int[] val, int[] arr) {
            propagate(arr);
            if (rightMost < i) {
                return 0;
            }
            if (i <= leftMost && val[0] >= sum) {
                val[0] -= sum;
                return rightMost - leftMost + 1;
            }
            if (leftMost == rightMost) {
                return 0;
            }
            if (arr[rightMost] > val[0]) {
                return 0;
            }
            return left.query(i, val, arr) + right.query(i, val, arr);
        }

        private void update(int i, int v, int[] arr) {
            propagate(arr);
            if (leftMost > i || arr[rightMost] >= v) {
                return;
            }
            if (rightMost <= i && arr[leftMost] <= v) {
                sum = (long) (rightMost - leftMost + 1) * v;
                operation = v;
                arr[leftMost] = arr[rightMost] = v;
                return;
            }
            left.update(i, v, arr);
            right.update(i, v, arr);
            sum = left.sum + right.sum;
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final int q = fs.nextInt();
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
        }
        final SegTree st = new SegTree(0, n - 1, arr);
        for (int i = 0; i < q; i++) {
            final int type = fs.nextInt();
            final int x = fs.nextInt() - 1;
            final int y = fs.nextInt();
            if (type == 1) {
                st.update(x, y, arr);
            } else {
                pw.println(st.query(x, new int[] { y }, arr));
            }
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
