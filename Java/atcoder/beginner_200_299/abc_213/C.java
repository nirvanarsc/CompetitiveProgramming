package atcoder.beginner_200_299.abc_213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final StringBuilder sb = new StringBuilder();
        final int h = fs.nextInt();
        final int w = fs.nextInt();
        final int n = fs.nextInt();
        final int[][] g = new int[n][2];
        final Set<Integer> xx = new HashSet<>();
        final Set<Integer> yy = new HashSet<>();
        for (int i = 0; i < n; i++) {
            final int u = fs.nextInt();
            final int v = fs.nextInt();
            g[i] = new int[] { u, v };
            xx.add(u);
            yy.add(v);
        }
        final int[] x = new int[xx.size()];
        final int[] y = new int[yy.size()];
        final Iterator<Integer> xIterator = xx.iterator();
        final Iterator<Integer> yIterator = yy.iterator();
        for (int i = 0; xIterator.hasNext(); i++) {
            x[i] = xIterator.next();
        }
        for (int i = 0; yIterator.hasNext(); i++) {
            y[i] = yIterator.next();
        }
        Utils.shuffleSort(x);
        Utils.shuffleSort(y);
        for (int i = 0; i < n; i++) {
            sb.append(lowerBound(x, g[i][0]) + 1).append(' ').append(lowerBound(y, g[i][1]) + 1).append('\n');
        }
        System.out.println(sb);
    }

    private static int lowerBound(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
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
