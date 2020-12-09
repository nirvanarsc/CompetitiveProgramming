package codeforces.round_600_649.round_631;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

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
                sum ^= val;
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
        outer:
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int[] arr = new int[n];
            final int[] freq = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
                freq[arr[i]]++;
            }
            for (int i = 1; i < n; i++) {
                if (freq[i] > 2) {
                    System.out.println(0);
                    continue outer;
                }
            }
            final List<int[]> res = new ArrayList<>();
            final SegTree ll = new SegTree(0, n - 1, new int[n]);
            final SegTree rr = new SegTree(0, n - 1, new int[n]);
            for (int i = 0; i < n; i++) {
                rr.update(arr[i], 1);
            }
            for (int i = 0; i < n; i++) {
                ll.update(arr[i], 1);
                rr.update(arr[i], 1);
                final int sumL = ll.query(1, i + 1);
                final int sumR = rr.query(1, n - i - 1);
                if (sumL == i + 1 && sumR == (n - i - 1)) {
                    res.add(new int[] { i + 1, n - i - 1 });
                }
            }
            System.out.println(res.size());
            for (int[] sol : res) {
                System.out.println(sol[0] + " " + sol[1]);
            }
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
