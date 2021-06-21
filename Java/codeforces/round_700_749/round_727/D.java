package codeforces.round_700_749.round_727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final List<long[]> list = new ArrayList<>();
        long total = 0;
        for (int i = 0; i < n; i++) {
            list.add(new long[] { fs.nextLong(), fs.nextLong() });
            total += list.get(i)[0];
        }
        list.sort(Comparator.comparingLong(a -> a[1]));
        long lo = 0;
        long hi = total;
        while (lo < hi) {
            final long mid = lo + hi >>> 1;
            if (!f(mid, list)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        System.out.println(total + lo);
    }

    private static boolean f(long mid, List<long[]> l) {
        long bought = 0;
        final Deque<long[]> dq = new ArrayDeque<>();
        for (long[] tt : l) {
            dq.offerLast(tt);
        }
        while (bought < mid) {
            final long[] curr = dq.removeLast();
            final long min = Math.min(curr[0], mid - bought);
            bought += min;
            if (min != curr[0]) {
                dq.offerLast(new long[] { mid - bought, curr[1] });
            }
        }
        while (!dq.isEmpty()) {
            final long[] curr = dq.removeFirst();
            if (bought < curr[1]) {
                return false;
            }
            bought += curr[0];
        }
        return true;
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
