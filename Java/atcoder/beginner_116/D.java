package atcoder.beginner_116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        final int k = fs.nextInt();
        final int[] type = new int[n];
        final int[] delicious = new int[n];
        final Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            type[i] = fs.nextInt();
            delicious[i] = fs.nextInt();
            arr[i] = i;
        }
        Arrays.sort(arr, (a, b) -> type[a] != type[b] ? Integer.compare(type[a], type[b])
                                                      : Integer.compare(delicious[b], delicious[a]));
        final Integer[] unique = new Integer[n];
        int idx = 0, m = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || type[arr[i - 1]] != type[arr[i]]) {
                unique[m++] = arr[i];
            } else {
                arr[idx++] = arr[i];
            }
        }
        n = idx;
        Arrays.sort(arr, 0, n, (a, b) -> Integer.compare(delicious[b], delicious[a]));
        Arrays.sort(unique, 0, m, (a, b) -> Integer.compare(delicious[b], delicious[a]));
        final long[] pp = new long[n + 1];
        final long[] qq = new long[m + 1];
        for (int i = 0; i < n; i++) {
            pp[i + 1] = pp[i] + delicious[arr[i]];
        }
        for (int j = 0; j < m; j++) {
            qq[j + 1] = qq[j] + delicious[unique[j]];
        }
        long ans = 0;
        for (int x = Math.max(1, k - n); x <= k && x <= m; x++) {
            ans = Math.max(ans, qq[x] + pp[k - x] + (long) x * x);
        }
        System.out.println(ans);
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
