package atcoder.beginner_100_199.beginner_136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    private static final int MOD = 998244353;

    private static long add(long a, long b) {
        return (a + b) % MOD;
    }

    private static long sub(long a, long b) {
        if (a < b) {
            return a - b + MOD;
        }
        return a - b;
    }

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
        final int[] x = new int[n];
        final int[] y = new int[n];
        final SegTree st = new SegTree(0, n - 1, new int[n]);
        final List<int[]> points = new ArrayList<>(n);
        final Map<Integer, Integer> origX = new HashMap<>();
        final Map<Integer, Integer> origY = new HashMap<>();
        final long[] pow2 = new long[n + 1];
        pow2[0] = 1;
        long pp = 1;
        for (int i = 0; i < n; i++) {
            x[i] = fs.nextInt();
            origX.put(x[i], i);
            y[i] = fs.nextInt();
            origY.put(y[i], i);
            points.add(new int[2]);
            pp = (pp * 2) % MOD;
            pow2[i + 1] = pp;
        }
        Utils.shuffleSort(x);
        Utils.shuffleSort(y);
        int currX = 0;
        int currY = 0;
        for (int xx : x) {
            points.get(origX.get(xx))[0] = currX++;
        }
        for (int yy : y) {
            points.get(origY.get(yy))[1] = currY++;
        }
        points.sort(Comparator.comparingInt(val -> val[0]));
        long res = 0;
        for (int[] p : points) {
            res = add(res, pow2[n]);

            final int countAbove = n - p[1] - 1;
            final int countBelow = p[1];
            final int countLeft = p[0];
            final int countRight = n - p[0] - 1;
            res = sub(res, pow2[countAbove]);
            res = sub(res, pow2[countBelow]);
            res = sub(res, pow2[countLeft]);
            res = sub(res, pow2[countRight]);

            final int leftAbove = st.query(p[1], n);
            final int leftBelow = st.query(0, p[1]);
            final int rightAbove = countAbove - leftAbove;
            final int rightBelow = countBelow - leftBelow;
            res = add(res, pow2[leftAbove]);
            res = add(res, pow2[leftBelow]);
            res = add(res, pow2[rightAbove]);
            res = add(res, pow2[rightBelow]);

            res = sub(res, 1);

            st.update(p[1], 1);
        }
        System.out.println(res);
    }

    static final class Utils {
        public static void shuffleSort(int[] arr) {
            shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffleSort(long[] arr) {
            shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffle(int[] arr) {
            final Random r = new Random();

            for (int i = 0; i <= arr.length - 2; i++) {
                final int j = i + r.nextInt(arr.length - i);
                swap(arr, i, j);
            }
        }

        public static void shuffle(long[] arr) {
            final Random r = new Random();

            for (int i = 0; i <= arr.length - 2; i++) {
                final int j = i + r.nextInt(arr.length - i);
                swap(arr, i, j);
            }
        }

        public static void swap(int[] arr, int i, int j) {
            final int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

        public static void swap(long[] arr, int i, int j) {
            final long t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
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
