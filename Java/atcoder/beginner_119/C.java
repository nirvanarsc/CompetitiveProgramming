package atcoder.beginner_119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    static int a, b, c;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        a = fs.nextInt();
        b = fs.nextInt();
        c = fs.nextInt();
        final int[] bamboos = fs.nextIntArray(n);
        System.out.println(dfs(bamboos, 0, 0, 0, 0));
    }

    private static long dfs(int[] bamboos, int idx, int x, int y, int z) {
        if (idx == bamboos.length) {
            if (x == 0 || y == 0 || z == 0) {
                return Integer.MAX_VALUE;
            }
            return Math.abs(x - a) + Math.abs(y - b) + Math.abs(z - c);
        }
        final long op1 = dfs(bamboos, idx + 1, x, y, z);
        final long op2 = dfs(bamboos, idx + 1, x + bamboos[idx], y, z) + ((x > 0) ? 10 : 0);
        final long op3 = dfs(bamboos, idx + 1, x, y + bamboos[idx], z) + ((y > 0) ? 10 : 0);
        final long op4 = dfs(bamboos, idx + 1, x, y, z + bamboos[idx]) + ((z > 0) ? 10 : 0);
        return Math.min(op1, Math.min(op2, Math.min(op3, op4)));
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
