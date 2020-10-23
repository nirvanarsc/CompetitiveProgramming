package cses.sorting_searching;

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

public final class SumTwoValues {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int t = fs.nextInt();
        final int[] arr = new int[n];
        final Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
            map.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i + 1);
        }
        Utils.shuffleSort(arr);
        int i = 0;
        int j = n - 1;
        while (i < j) {
            while (i > 0 && i < j && arr[i - 1] == arr[i]) { i++; }
            while (j < n - 1 && i < j && arr[j + 1] == arr[j]) { j--; }
            if (arr[i] + arr[j] > t) {
                j--;
            } else if (arr[i] + arr[j] < t) {
                i++;
            } else {
                if (arr[i] == arr[j]) {
                    System.out.println(map.get(arr[i]).get(0) + " " + map.get(arr[i]).get(1));
                } else {
                    System.out.println(map.get(arr[i]).get(0) + " " + map.get(arr[j]).get(0));
                }
                return;
            }
        }
        System.out.println("IMPOSSIBLE");
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
