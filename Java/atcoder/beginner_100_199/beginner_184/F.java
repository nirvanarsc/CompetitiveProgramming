package atcoder.beginner_100_199.beginner_184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int t = fs.nextInt();
        final int[] arr = fs.nextIntArray(n);
        final int[] half1 = new int[n / 2];
        final int[] half2 = new int[n / 2 + n % 2];
        int idx = 0;
        for (int i = 0; i < half1.length; i++) {
            half1[i] = arr[idx++];
        }
        for (int i = 0; i < half2.length; i++) {
            half2[i] = arr[idx++];
        }
        final List<Integer> sum1 = new ArrayList<>();
        final List<Integer> sum2 = new ArrayList<>();
        final int l1 = half1.length;
        final int l2 = half2.length;
        for (int mask = 0; mask < (1 << l2); mask++) {
            long curr = 0;
            for (int i = 0; i < l2; i++) {
                if ((mask & (1 << i)) != 0) {
                    curr += half2[i];
                }
            }
            if (curr <= t) {
                sum2.add((int) curr);
            }
        }
        for (int mask = 0; mask < (1 << l1); mask++) {
            long curr = 0;
            for (int i = 0; i < l1; i++) {
                if ((mask & (1 << i)) != 0) {
                    curr += half1[i];
                }
            }
            if (curr <= t) {
                sum1.add((int) curr);
            }
        }
        sum2.sort(Comparator.naturalOrder());
        long best = 0;
        for (int s1 : sum1) {
            if (s1 <= t) {
                best = Math.max(best, s1 + sum2.get(upperBound(sum2, t - s1)));
            }
        }
        System.out.println(best);
    }

    private static int upperBound(List<Integer> nums, int target) {
        int lo = 0;
        int hi = nums.size() - 1;
        while (lo < hi) {
            final int mid = (lo + hi + 1) >>> 1;
            if (nums.get(mid) > target) {
                hi = mid - 1;
            } else {
                lo = mid;
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
