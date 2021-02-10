package atcoder.beginner_100_199.beginner_166;

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
        final int[] arr = fs.nextIntArray(3);
        final List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            final String curr = fs.next();
            final int a;
            final int b;
            if ("AB".equals(curr)) {
                a = 0;
                b = 1;
            } else if ("AC".equals(curr)) {
                a = 0;
                b = 2;
            } else {
                a = 1;
                b = 2;
            }
            pairs.add(new int[] { a, b });
        }
        final char[] res = new char[n];
        pairs.add(new int[] { 0, 1 });
        for (int i = 0; i < n; i++) {
            final int a = pairs.get(i)[0];
            final int b = pairs.get(i)[1];
            if (arr[a] == 0 && arr[b] == 0) {
                System.out.println("No");
                return;
            }
            if (arr[a] == 0) {
                add(a, b, arr, res, i);
            } else if (arr[b] == 0) {
                add(b, a, arr, res, i);
            } else {
                final int na = pairs.get(i + 1)[0];
                final int nb = pairs.get(i + 1)[1];
                if (a == na || a == nb) {
                    add(a, b, arr, res, i);
                } else {
                    add(b, a, arr, res, i);
                }
            }
        }
        System.out.println("Yes");
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
    }

    private static void add(int a, int b, int[] arr, char[] res, int idx) {
        arr[a]++;
        arr[b]--;
        res[idx] = (char) ('A' + a);
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
