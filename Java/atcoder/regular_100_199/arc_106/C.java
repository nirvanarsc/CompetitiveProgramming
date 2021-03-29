package atcoder.regular_100_199.arc_106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        if (m < 0) {
            System.out.println(-1);
            return;
        }
        if (n == 1) {
            if (m == 0) {
                System.out.println(1 + " " + 10);
            } else {
                System.out.println(-1);
            }
            return;
        }
        if (n == 2) {
            if (m == 0) {
                System.out.println(1 + " " + 10);
                System.out.println(11 + " " + 20);
            } else {
                System.out.println(-1);
            }
            return;
        }
        if (m == n || m == n - 1) {
            System.out.println(-1);
            return;
        }
        final int overlaps = m == 0 ? 0 : 1 + m;
        pw.println(1 + " " + (int) 1e6);
        int prevE = 1;
        for (int i = 0; i < overlaps; i++) {
            pw.println((prevE + 1) + " " + (prevE + 2));
            prevE += 2;
        }
        prevE = (int) 1e6;
        for (int i = 0; i < (n - overlaps - 1); i++) {
            pw.println((prevE + 1) + " " + (prevE + 2));
            prevE += 2;
        }
        pw.close();
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
