package codeforces.round_650_699.round_694;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class A {

    public int findKthPositive(int[] arr, int k) {
        if (arr[arr.length - 1] - arr.length < k) {
            return arr.length + k;
        }

        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + hi + 1 >>> 1;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo + k + 1;
    }

    public static void main(String[] args) {
        System.out.println(new A().findKthPositive(new int[] { 2 }, 1));
    }

//    public static void main(String[] args) {
//        final FastScanner fs = new FastScanner();
//        final int t = fs.nextInt();
//        for (int test = 0; test < t; test++) {
//            final int n = fs.nextInt();
//            final int x = fs.nextInt();
//            long min = 0;
//            long max = 0;
//            for (int i = 0; i < n; i++) {
//                final int curr = fs.nextInt();
//                max += curr / x + (curr % x != 0 ? 1 : 0);
//                min += curr;
//            }
//            min = min / x + (min % x != 0 ? 1 : 0);
//            System.out.println(min + " " + max);
//        }
//    }

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
