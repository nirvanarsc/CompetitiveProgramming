package codeforces.round_650_699.round_689;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int q = fs.nextInt();
            final int[] arr = fs.nextIntArray(n);
            Utils.shuffleSort(arr);
            final Set<Long> sums = new HashSet<>();
            final long[] preSum = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + arr[i - 1];
            }
            dfs(arr, preSum, 0, n - 1, sums);
            for (int i = 0; i < q; i++) {
                final long sum = fs.nextLong();
                pw.println(sums.contains(sum) ? "Yes" : "No");
            }
        }
        pw.close();
    }

    private static void dfs(int[] arr, long[] preSum, int ll, int rr, Set<Long> sums) {
        sums.add(preSum[rr + 1] - preSum[ll]);
        if (arr[ll] == arr[rr]) {
            return;
        }
        final int mid = arr[rr] + arr[ll] >>> 1;
        final int midIdx = upperBound(arr, mid);
        dfs(arr, preSum, ll, midIdx, sums);
        dfs(arr, preSum, midIdx + 1, rr, sums);
    }

    private static int upperBound(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int mid = (lo + hi + 1) >>> 1;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

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
