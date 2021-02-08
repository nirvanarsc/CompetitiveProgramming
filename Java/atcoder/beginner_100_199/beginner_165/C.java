package atcoder.beginner_100_199.beginner_165;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int q = fs.nextInt();
        final int[][] arr = new int[q][4];
        for (int i = 0; i < q; i++) {
            arr[i] = new int[] { fs.nextInt(), fs.nextInt(), fs.nextInt(), fs.nextInt() };
        }
        final List<Integer> list = new ArrayList<>(Collections.singletonList(1));
        final int[] res = { 0 };
        dfs(list, res, arr, n, m);
        System.out.println(res[0]);
    }

    private static void dfs(List<Integer> list, int[] res, int[][] q, int n, int m) {
        if (list.size() == n + 1) {
            int curr = 0;
            for (int[] qq : q) {
                if (list.get(qq[1]) - list.get(qq[0]) == qq[2]) {
                    curr += qq[3];
                }
            }
            res[0] = Math.max(res[0], curr);
            return;
        }
        list.add(list.get(list.size() - 1));
        while (list.get(list.size() - 1) <= m) {
            dfs(list, res, q, n, m);
            list.set(list.size() - 1, list.get(list.size() - 1) + 1);
        }
        list.remove(list.size() - 1);
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
