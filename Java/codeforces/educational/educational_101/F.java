package codeforces.educational.educational_101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

@SuppressWarnings("TailRecursion")
public final class F {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long sum;
        long operation;

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

        private void propagate() {
            if (leftMost == rightMost) {
                return;
            }
            left.operation += operation;
            right.operation += operation;
            left.sum += (left.rightMost - left.leftMost + 1) * operation;
            right.sum += (right.rightMost - right.leftMost + 1) * operation;
            operation = 0;
        }

        private int query(long k) {
            propagate();
            if (leftMost == rightMost) {
                return leftMost;
            }
            if (left.sum <= k) {
                return right.query(k - left.sum);
            }
            return left.query(k);
        }

        private void add(int l, int r, long v) {
            propagate();
            if (r < leftMost || l > rightMost) {
                return;
            }
            if (l <= leftMost && rightMost <= r) {
                sum += (rightMost - leftMost + 1) * v;
                operation += v;
                return;
            }
            left.add(l, r, v);
            right.add(l, r, v);
            sum = left.sum + right.sum;
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int k = fs.nextInt();
        final int[] chains = fs.nextIntArray(n);
        final int[] arr = new int[(int) (2e5 + 5)];
        arr[0] = 1;
        final SegTree st = new SegTree(0, arr.length - 1, arr);
        int res = (int) 1e9;
        Utils.shuffleSort(chains);
        for (int i = n - 1; i >= 0; i--) {
            final int firstOne = st.query(0);
            st.add(firstOne, firstOne, -1);
            final int chain = chains[i];
            final int ll = (chain - 1) / 2;
            final int rr = chain - 1 - ll;
            st.add(firstOne + 2, firstOne + 1 + ll, 1);
            st.add(firstOne + 2, firstOne + 1 + rr, 1);
            if (st.sum >= k) {
                res = Math.min(res, st.query(k - 1));
            }
        }
        System.out.println(res == (int) 1e9 ? -1 : res);
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
