package atcoder.beginner_127;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    public static class MedianFinder {

        PriorityQueue<Integer> max;
        PriorityQueue<Integer> min;
        long leftSum;
        long rightSum;

        public MedianFinder() {
            max = new PriorityQueue<>(Comparator.reverseOrder());
            min = new PriorityQueue<>();
        }

        public void addNum(int num) {
            min.add(num);
            int pop = min.remove();
            max.add(pop);
            leftSum += num;
            leftSum -= pop;
            rightSum += pop;
            if (max.size() > min.size()) {
                pop = max.remove();
                min.add(pop);
                rightSum -= pop;
                leftSum += pop;
            }
        }

        public long findMedian() {
            if (min.size() != max.size()) {
                return min.element();
            } else {
                return max.element();
            }
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int q = fs.nextInt();
        final MedianFinder mf = new MedianFinder();
        long b = 0;
        for (int i = 0; i < q; i++) {
            final int type = fs.nextInt();
            if (type == 1) {
                final int l = fs.nextInt();
                final int r = fs.nextInt();
                mf.addNum(l);
                b += r;
            } else {
                final long median = mf.findMedian();
                final long res = mf.min.size() * median - mf.leftSum + mf.rightSum - mf.max.size() * median;
                System.out.println(median + " " + (-res + b));
            }
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
