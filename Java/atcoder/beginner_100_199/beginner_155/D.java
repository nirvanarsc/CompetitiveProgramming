package atcoder.beginner_100_199.beginner_155;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final long k = fs.nextLong();
        final int[] arr = fs.nextIntArray(n);
        Utils.shuffleSort(arr);
        long lo = (long) -2e18;
        long hi = (long) 2e18;
        while (lo < hi) {
            final long mid = lo + hi + 1 >> 1;
            if (f(arr, mid) < k) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(lo);
    }

    private static long f(int[] arr, long mid) {
        long count = 0;
        for (int num : arr) {
            int lo = 0;
            int hi = arr.length;
            if (num < 0) {
                while (lo < hi) {
                    final int m = lo + hi >>> 1;
                    if ((long) arr[m] * num >= mid) {
                        lo = m + 1;
                    } else {
                        hi = m;
                    }
                }
                count += arr.length - lo;
            } else {
                while (lo < hi) {
                    final int m = lo + hi >>> 1;
                    if ((long) arr[m] * num < mid) {
                        lo = m + 1;
                    } else {
                        hi = m;
                    }
                }
                count += lo;
            }
            if ((long) num * num < mid) {
                count--;
            }
        }
        return count / 2;
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
