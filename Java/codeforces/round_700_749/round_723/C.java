package codeforces.round_700_749.round_723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        long add;
        long min;

        SegTree(int leftMost, int rightMost, long[] arr) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
            if (leftMost == rightMost) {
                min = arr[leftMost];
            } else {
                final int mid = leftMost + rightMost >>> 1;
                left = new SegTree(leftMost, mid, arr);
                right = new SegTree(mid + 1, rightMost, arr);
                recalc();
            }
        }

        private void recalc() {
            min = Math.min(apply(left), apply(right));
        }

        private void propagate() {
            left.compose(add);
            right.compose(add);
            add = 0;
        }

        private void compose(long add) {
            this.add += add;
        }

        private static long apply(SegTree st) {
            return st.min + st.add;
        }

        private long query(int l, int r) {
            if (l > rightMost || r < leftMost) {
                return (long) 1e18;
            }
            if (l <= leftMost && rightMost <= r) {
                return apply(this);
            }
            propagate();
            recalc();
            return Math.min(left.query(l, r), right.query(l, r));
        }

        private void update(int l, int r, long add) {
            if (l > rightMost || r < leftMost) {
                return;
            }
            if (l <= leftMost && rightMost <= r) {
                compose(add);
                return;
            }
            propagate();
            left.update(l, r, add);
            right.update(l, r, add);
            recalc();
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[] arr = fs.nextIntArray(n);
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0]
                                                                      ? Integer.compare(b[1], a[1])
                                                                      : Integer.compare(b[0], a[0]));
        final long[] pre = new long[n];
        long curr = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                pq.offer(new int[] { arr[i], i });
            } else {
                curr += arr[i];
                res++;
            }
            pre[i] = curr;
        }
        final SegTree st = new SegTree(0, n - 1, pre);
        while (!pq.isEmpty()) {
            final int[] neg = pq.remove();
            final long at = st.query(neg[1], n - 1);
            if (at >= -neg[0]) {
                res++;
                st.update(neg[1], n - 1, neg[0]);
            }
        }
        System.out.println(res);
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
