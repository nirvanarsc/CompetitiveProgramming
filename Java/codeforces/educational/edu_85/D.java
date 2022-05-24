package codeforces.educational.edu_85;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final long l = fs.nextLong();
            final long r = fs.nextLong();
            final long total = (long) n * (n - 1) + 1;
            int p = lowerBound(l, n);
            final long startingIdx = total - (long) (n - p) * (n - p + 1);
            final long diff = l - startingIdx;
            long q = p + (diff + 2) / 2;
            long idx = l;
            for (int i = 0; i < (r - l + 1); i++, idx++) {
                if (q == n + 1) {
                    p += 1;
                    if (p >= n) {
                        p = 1;
                    }
                    q = p + 1;
                }
                if (idx % 2 != 0) {
                    System.out.print(p + " ");
                } else {
                    System.out.print(q + " ");
                    q += 1;
                }
            }
            System.out.println();
        }
    }

    private static int lowerBound(long t, int n) {
        int lo = 1;
        int hi = n;
        final long total = (long) n * (n - 1) + 1;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            final long curr = (long) (n - mid - 1) * (n - mid) + 1;
            if (total - curr < t) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
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
