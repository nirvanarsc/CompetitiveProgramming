package codeforces.round_650_699.round_695;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int j = fs.nextInt();
        final int k = fs.nextInt();
        final int l = fs.nextInt();
        final int[] min = new int[3];
        Arrays.fill(min, (int) 2e9);
        final long[] sum = new long[3];
        for (int i = 0; i < j; i++) {
            final int curr = fs.nextInt();
            min[0] = Math.min(min[0], curr);
            sum[0] += curr;
        }
        for (int i = 0; i < k; i++) {
            final int curr = fs.nextInt();
            min[1] = Math.min(min[1], curr);
            sum[1] += curr;
        }
        for (int i = 0; i < l; i++) {
            final int curr = fs.nextInt();
            min[2] = Math.min(min[2], curr);
            sum[2] += curr;
        }
        Arrays.sort(min);
        Arrays.sort(sum);
        final long total = sum[0] + sum[1] + sum[2];
        System.out.println(Math.max(total - 2 * sum[0], total - 2 * (min[0] + min[1])));
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
