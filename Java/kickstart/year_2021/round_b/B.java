package kickstart.year_2021.round_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int x = 1; x <= t; x++) {
            final int n = fs.nextInt();
            final int[] arr = fs.nextIntArray(n);
            final int[] d1 = new int[n - 1];
            final int[] d2 = new int[n - 1];
            for (int i = 1; i < n; i++) {
                d1[i - 1] = arr[i] - arr[i - 1];
            }
            for (int i = n - 1; i >= 1; i--) {
                d2[n - i - 1] = arr[i] - arr[i - 1];
            }
            System.out.println("Case #" + x + ": " + Math.max(solve(d1), solve(d2)));
        }
    }

    private static int solve(int[] d) {
        final int n = d.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && d[i] == d[j]) {
                j++;
            }
            res = Math.max(res, j - i + 1);
            if (j < n) {
                res = Math.max(res, j - i + 2);
            }
            if (j < n - 1 && d[j] + d[j + 1] == 2 * d[i]) {
                int end = j + 2;
                while (end < n && d[end] == d[i]) {
                    end++;
                }
                res = Math.max(res, end - i + 1);
            }
            i = j - 1;
        }
        return res;
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
