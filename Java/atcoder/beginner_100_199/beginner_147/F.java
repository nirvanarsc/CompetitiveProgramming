package atcoder.beginner_100_199.beginner_147;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        long x = fs.nextLong();
        long d = fs.nextLong();
        if (d == 0) {
            if (x == 0) {
                System.out.println(1);
            } else {
                System.out.println(n + 1);
            }
            return;
        }
        if (d < 0) {
            x = -x;
            d = -d;
        }
        final long total = ((long) n * (n - 1)) / 2;
        final List<long[]> p = new ArrayList<>();
        long res = 0;
        for (int k = 0; k <= n; k++) {
            final long lK = ((long) k * (k - 1)) / 2;
            final long rK = total - ((long) (n - k) * (n - k - 1)) / 2;
            p.add(new long[] { x * k + lK * d, 1 });
            p.add(new long[] { x * k + rK * d, -1 });
        }
        p.sort((a, b) -> a[0] == b[0] ? Long.compare(b[1], a[1]) : Long.compare(a[0], b[0]));
        int open = 0;
        long start = 0;
        for (long[] pp : p) {
            System.out.println(Arrays.toString(pp) + " " + open);
            if (open == 0) {
                start = pp[0];
            }
            open += pp[1];
            if (open == 0) {
                res += 1 + ((pp[0] - start) / d);
            }
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
