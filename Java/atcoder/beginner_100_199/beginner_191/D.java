package atcoder.beginner_100_199.beginner_191;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final long x = Math.round(Double.parseDouble(fs.next()) * 1e4);
        final long y = Math.round(Double.parseDouble(fs.next()) * 1e4);
        final long r = Math.round(Double.parseDouble(fs.next()) * 1e4);
        final long sqr = r * r;
        long res = 0;
        for (int i = (int) -2e9; i <= (int) 2e9; i += 10000) {
            if (i < x - r || i > x + r) { continue; }
            final long curr = (i - x) * (i - x);
            final long sqrt = (long) Math.sqrt(sqr - curr);
            long rr = y + sqrt + 5;
            long ll = y - sqrt - 5;
            while ((rr - y) * (rr - y) + curr > sqr) { --rr; }
            while ((ll - y) * (ll - y) + curr > sqr) { ++ll; }
            // floor
            final int addR = (rr >= 0 || rr % 10000 == 0) ? 0 : 1;
            // ceil
            final int addL = (ll <= 0 || ll % 10000 == 0) ? 0 : 1;
            rr = rr / 10000 - addR;
            ll = ll / 10000 + addL;
            res += rr - ll + 1;
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
