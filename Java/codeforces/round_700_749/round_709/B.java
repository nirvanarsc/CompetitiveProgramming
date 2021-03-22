package codeforces.round_700_749.round_709;

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
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int[] arr = fs.nextIntArray(n);
            if (allSameDiff(arr)) {
                System.out.println(0);
                continue;
            }
            int posDiff = -1;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    posDiff = arr[i + 1] - arr[i];
                    break;
                }
            }
            if (posDiff == -1) {
                System.out.println(-1);
                continue;
            }
            int mod = -1;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    mod = arr[i] + posDiff - arr[i + 1];
                }
            }
            if (mod == -1) {
                System.out.println(-1);
                continue;
            }
            boolean ok = true;
            final int c = posDiff;
            final int m = mod;
            for (int i = 1; i < n; i++) {
                if ((arr[i - 1] + c) % m != arr[i]) {
                    ok = false;
                    break;
                }
            }
            if (arr[0] >= m) {
                ok = false;
            }
            if (!ok) {
                System.out.println(-1);
            } else {
                System.out.println(mod + " " + c);
            }
        }
    }

    private static boolean allSameDiff(int[] arr) {
        if (arr.length == 1) {
            return true;
        }
        final int diff = arr[0] - arr[1];
        for (int i = 0; i < arr.length - 1; i++) {
            if (diff != arr[i] - arr[i + 1]) {
                return false;
            }
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
