package atcoder.beginner_100_199.beginner_112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[][] tuples = new int[n][3];
        int[] G = new int[3];
        final List<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            final int x = fs.nextInt();
            final int y = fs.nextInt();
            final int h = fs.nextInt();
            tuples[i] = new int[] { x, y, h };
            if (h >= 1) {
                G = new int[] { x, y, h };
            }
        }
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                final int V = Math.max(0, G[2] + Math.abs(i - G[0]) + Math.abs(j - G[1]));
                boolean flag = true;
                for (int[] point : tuples) {
                    final int VV = Math.max(0, V - Math.abs(point[0] - i) - Math.abs(point[1] - j));
                    if (point[2] != VV) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res.add(new int[] { i, j, V });
                }
            }
        }
        if (res.size() == 1) {
            final int[] ints = res.get(0);
            System.out.println(ints[0] + " " + ints[1] + ' ' + ints[2]);
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
