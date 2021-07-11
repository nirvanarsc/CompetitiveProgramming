package kickstart.year_2021.round_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;

public final class C {

    class MedianFinder {

        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;

        public MedianFinder() {
            min = new PriorityQueue<>(Comparator.naturalOrder());
            max = new PriorityQueue<>(Comparator.reverseOrder());
        }

        public void addNum(int num) {
            min.add(num);
            max.add(min.remove());
            if (max.size() > min.size()) {
                min.add(max.remove());
            }
        }

        public double findMedian() {
            final int size = min.size() + max.size();
            if (size % 2 == 0) {
                return 0.5 * (min.element() + max.element());
            }
            return min.element();
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int x = 1; x <= t; x++) {
            final TreeSet<long[]> ts = new TreeSet<>(Comparator.comparingLong(a -> a[0]));
            final int n = fs.nextInt();
            final int m = fs.nextInt();
            for (int i = 0; i < n; i++) {
                ts.add(new long[] { fs.nextLong(), fs.nextLong() });
            }
            final long[] res = new long[m];
            for (int i = 0; i < m; i++) {
                final long s = fs.nextLong();
                final long[] tt = { s };
                final long[] lower = ts.lower(tt);
                final long[] ceil = ts.ceiling(tt);
                if (lower == null) {
                    //noinspection ConstantConditions
                    res[i] = ceil[0];
                    ts.remove(ceil);
                    if (ceil[0] != ceil[1]) {
                        ts.add(new long[] { ceil[0] + 1, ceil[1] });
                    }
                } else if (ceil == null) {
                    final long bestLo = Math.min(s, lower[1]);
                    ts.remove(lower);
                    final long[] ll = { lower[0], bestLo - 1 };
                    final long[] rr = { bestLo + 1, lower[1] };
                    if (ll[0] <= ll[1]) {
                        ts.add(ll);
                    }
                    if (rr[0] <= rr[1]) {
                        ts.add(rr);
                    }
                    res[i] = bestLo;
                } else {
                    final long bestLo = Math.min(s, lower[1]);
                    final long bestHi = Math.max(s, ceil[0]);
                    if (s - bestLo <= bestHi - s) {
                        ts.remove(lower);
                        final long[] ll = { lower[0], bestLo - 1 };
                        final long[] rr = { bestLo + 1, lower[1] };
                        if (ll[0] <= ll[1]) {
                            ts.add(ll);
                        }
                        if (rr[0] <= rr[1]) {
                            ts.add(rr);
                        }
                        res[i] = bestLo;
                    } else {
                        ts.remove(ceil);
                        final long[] ll = { ceil[0], bestHi - 1 };
                        final long[] rr = { bestHi + 1, ceil[1] };
                        if (ll[0] <= ll[1]) {
                            ts.add(ll);
                        }
                        if (rr[0] <= rr[1]) {
                            ts.add(rr);
                        }
                        res[i] = bestHi;
                    }
                }
            }
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(res[i]).append(' ');
            }
            System.out.println("Case #" + x + ": " + sb);
        }
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
