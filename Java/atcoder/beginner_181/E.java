package atcoder.beginner_181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    // TODO CHECK TEST
    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int[] arr1 = fs.nextIntArray(n);
        final int[] arr2 = fs.nextIntArray(m);
        Utils.shuffleSort(arr1);
        Utils.shuffleSort(arr2);
        if (n == 1) {
            long res = (long) 2e18;
            for (int num : arr2) {
                res = Math.min(res, num + arr1[0]);
            }
            System.out.println(res);
            return;
        }
        final long[] sums = new long[n - 1];
        for (int i = 0; i < n - 1; i++) {
            sums[i] = arr1[i + 1] - arr1[i];
        }
        final long[] partial = new long[(n + 1) / 2];
        for (int i = 1; i < sums.length; i += 2) {
            partial[0] += sums[i];
        }
        for (int i = 1, oddIdx = 1; i < partial.length; i++, oddIdx += 2) {
            partial[i] = partial[i - 1];
            partial[i] -= sums[oddIdx];
            partial[i] += sums[oddIdx - 1];
        }
        System.out.println(Arrays.toString(sums));
        System.out.println(Arrays.toString(partial));
        long res = (long) 2e18;
        for (int num : arr2) {
            int idx = lowerBound(arr1, num);
            if (idx % 2 != 0) {
                idx -= 1;
            }
            final long curr = partial[idx / 2] + Math.abs(num - arr1[idx]);
            res = Math.min(res, curr);
        }
        System.out.println(res);
    }

    public static int lowerBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
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
