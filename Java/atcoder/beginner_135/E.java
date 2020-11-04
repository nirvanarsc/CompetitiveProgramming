package atcoder.beginner_135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

@SuppressWarnings("SuspiciousNameCombination")
public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int k = fs.nextInt();
        int x = fs.nextInt();
        int y = fs.nextInt();
        if (k % 2 == 0 && Math.abs(x + y) % 2 != 0) {
            System.out.println(-1);
            return;
        }
        if (Math.abs(x) + Math.abs(y) == k) {
            System.out.println(1);
            System.out.println(x + " " + y);
            return;
        }
        final boolean f = x < y;
        if (x < y) {
            final int temp = x;
            x = y;
            y = temp;
        }
        final int gu = x - y;
        final int gv = x + y;
        int s = Math.max((Math.abs(gu) + k - 1) / k, (Math.abs(gv) + k - 1) / k);
        if (s == 1) {
            s += (gu < k || gv < k) ? 1 : 0;
        }
        if (k % 2 != 0 && s % 2 != gu % 2) {
            s++;
        }
        System.out.println(s);
        int u = 0;
        int v = 0;
        for (int i = 1; i <= s; i++) {
            final int du = u < gu ? 1 : -1;
            final int dv = v < gv ? 1 : -1;
            if (i == s) {
                u += du * k;
                v = gv;
            } else if (i == s - 1) {
                u = gu - du * k;
                v += dv * k;
            } else {
                u += du * k;
                v += dv * k;
            }
            x = (v + u) / 2;
            y = (v - u) / 2;
            if (f) {
                System.out.println(y + " " + x);
            } else {
                System.out.println(x + " " + y);
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
