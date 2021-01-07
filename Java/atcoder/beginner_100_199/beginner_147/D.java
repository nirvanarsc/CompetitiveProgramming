package atcoder.beginner_100_199.beginner_147;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final long[] arr = fs.nextLongArray(n);
        final int[] freq = new int[60];
        final long[] modPow = new long[60];
        for (int i = 0; i < 60; i++) {
            modPow[i] = (1L << i) % MOD;
        }
        for (int i = 1; i < n; i++) {
            final long curr = arr[i];
            for (int j = 0; j < 60; j++) {
                if ((curr & (1L << j)) != 0) {
                    freq[j]++;
                }
            }
        }
        long res = 0;
        for (int i = 0; i < n - 1; i++) {
            final long curr = arr[i];
            final long next = arr[i + 1];
            for (int j = 0; j < 60; j++) {
                final long add;
                if ((curr & (1L << j)) != 0) {
                    add = (modPow[j] * (n - 1 - i - freq[j])) % MOD;
                } else {
                    add = (modPow[j] * freq[j]) % MOD;
                }
                res = (res + add) % MOD;
                if ((next & (1L << j)) != 0) {
                    freq[j]--;
                }
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
