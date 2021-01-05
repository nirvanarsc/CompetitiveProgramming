package codeforces.round_650_699.round_693;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;

public final class E {

    private static class SegTree {
        int leftMost, rightMost;
        SegTree left, right;
        int[] min;

        SegTree(int leftMost, int rightMost, int[][] arr) {
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
            if (leftMost == rightMost) {
                return;
            }
            if (left.min[0] < right.min[0]) {
                min = left.min;
            } else {
                min = right.min;
            }
        }

        private int[] query(int l, int r) {
            if (r < leftMost || l > rightMost) {
                return new int[] { Integer.MAX_VALUE, -1 };
            }
            if (l <= leftMost && rightMost <= r) {
                return min;
            }
            final int[] ll = left.query(l, r);
            final int[] rr = right.query(l, r);
            if (ll[0] < rr[0]) {
                return ll;
            } else {
                return rr;
            }
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final TreeMap<Integer, int[]> tm = new TreeMap<>();
            final int[][] pairs = new int[n][2];
            for (int i = 0; i < n; i++) {
                final int h = fs.nextInt();
                final int w = fs.nextInt();
                pairs[i] = new int[] { h, w };
                final int[] curr = tm.get(h);
                if (curr == null) {
                    tm.put(h, new int[] { w, i });
                } else {
                    if (curr[0] > w) {
                        tm.put(h, new int[] { w, i });
                    }
                }
            }
            final int[][] rmq = new int[tm.keySet().size()][2];
            int idx = 0;
            final Map<Integer, Integer> indices = new HashMap<>();
            for (Map.Entry<Integer, int[]> entry : tm.entrySet()) {
                rmq[idx] = entry.getValue();
                indices.put(entry.getKey(), idx++);
            }
            final SegTree st = new SegTree(0, rmq.length - 1, rmq);
            for (int i = 0; i < n; i++) {
                final int h = pairs[i][0];
                final int w = pairs[i][1];
                final int t1 = f(tm, indices, st, w, h);
                final int t2 = f(tm, indices, st, h, w);
                if (t1 != -1) {
                    pw.print(t1 + " ");
                } else if (t2 != -1) {
                    pw.print(t2 + " ");
                } else {
                    pw.print(-1 + " ");
                }
            }
            pw.println();
        }
        pw.close();
    }

    private static int f(TreeMap<Integer, int[]> tm, Map<Integer, Integer> indices, SegTree st, int w, int h) {
        final Map.Entry<Integer, int[]> entry = tm.lowerEntry(h);
        if (entry == null) {
            return -1;
        } else {
            final int r = indices.get(entry.getKey());
            final int[] min = st.query(0, r);
            if (min[0] < w) {
                return min[1] + 1;
            } else {
                return -1;
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
