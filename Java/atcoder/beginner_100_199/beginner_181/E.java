package atcoder.beginner_100_199.beginner_181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int[] h = fs.nextIntArray(n);
        final int[] w = fs.nextIntArray(m);
        Utils.shuffleSort(h);
        final int[] even = new int[n];
        final int[] odd = new int[n];
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) {
                even[i] = h[i + 1] - h[i];
            } else {
                odd[i] = h[i + 1] - h[i];
            }
        }
        final long[] preEven = new long[n + 1];
        final long[] preOdd = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            preEven[i] = preEven[i - 1] + even[i - 1];
            preOdd[i] = preOdd[i - 1] + odd[i - 1];
        }
        long res = (long) 9e18;
        for (int num : w) {
            int idx = lowerBound(h, num);
            if (idx == n) {
                res = Math.min(res, preEven[n] + num - h[n - 1]);
            } else {
                if (idx % 2 != 0) {
                    idx--;
                }
                res = Math.min(res, preEven[idx] + Math.abs(num - h[idx]) + (preOdd[n] - preOdd[idx + 1]));
            }
        }
        System.out.println(res);
    }

    private static int lowerBound(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
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
