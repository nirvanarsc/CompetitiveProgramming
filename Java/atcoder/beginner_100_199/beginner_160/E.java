package atcoder.beginner_100_199.beginner_160;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int x = fs.nextInt();
        final int y = fs.nextInt();
        final int aL = fs.nextInt();
        final int bL = fs.nextInt();
        final int cL = fs.nextInt();
        final int[] a = fs.nextIntArray(aL);
        final int[] b = fs.nextIntArray(bL);
        final int[] c = fs.nextIntArray(cL);
        Utils.shuffleSort(a);
        Utils.shuffleSort(b);
        reverse(a, 0, aL - 1);
        reverse(b, 0, bL - 1);
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < x; i++) {
            pq.offer(a[i]);
        }
        for (int i = 0; i < y; i++) {
            pq.offer(b[i]);
        }
        for (int i = 0; i < cL; i++) {
            pq.offer(c[i]);
        }
        long res = 0;
        for (int i = 0; i < x + y; i++) {
            res += pq.remove();
        }
        System.out.println(res);
    }

    private static void reverse(int[] nums, int from, int to) {
        while (from < to) {
            final int t = nums[from];
            nums[from] = nums[to];
            nums[to] = t;
            from++;
            to--;
        }
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
