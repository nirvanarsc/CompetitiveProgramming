package atcoder.beginner_100_199.beginner_111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[] arr = fs.nextIntArray(n);
        final Map<Integer, Integer> left = new HashMap<>();
        final Map<Integer, Integer> right = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                left.merge(arr[i], 1, Integer::sum);
            } else {
                right.merge(arr[i], 1, Integer::sum);
            }
        }
        final List<int[]> ll = new ArrayList<>();
        final List<int[]> rr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : left.entrySet()) {
            ll.add(new int[] { e.getKey(), e.getValue() });
        }
        for (Map.Entry<Integer, Integer> e : right.entrySet()) {
            rr.add(new int[] { e.getKey(), e.getValue() });
        }
        ll.sort((a, b) -> Integer.compare(b[1], a[1]));
        rr.sort((a, b) -> Integer.compare(b[1], a[1]));
        int res = (int) 1e9;
        for (int i = 0; i < Math.min(ll.size(), 3); i++) {
            for (int j = 0; j < Math.min(rr.size(), 3); j++) {
                if (ll.get(i)[0] != rr.get(j)[0]) {
                    res = Math.min(res, n - (ll.get(i)[1] + rr.get(j)[1]));
                }
            }
        }
        System.out.println(res == (int) 1e9 ? n / 2 : res);
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
