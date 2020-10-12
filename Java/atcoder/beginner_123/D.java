package atcoder.beginner_123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int x = fs.nextInt();
        final int y = fs.nextInt();
        final int z = fs.nextInt();
        final int k = fs.nextInt();
        final long[] xx = fs.nextLongArray(x);
        final long[] yy = fs.nextLongArray(y);
        final long[] zz = fs.nextLongArray(z);
        final long[] xy = new long[x * y];
        int idx = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                xy[idx++] = xx[i] + yy[j];
            }
        }
        Arrays.sort(xy);
        Arrays.sort(zz);
        final long[] revXy = new long[x * y];
        final long[] revZ = new long[z];
        for (int i = x * y - 1, j = 0; i >= 0; i--, j++) {
            revXy[i] = xy[j];
        }
        for (int i = z - 1, j = 0; i >= 0; i--, j++) {
            revZ[i] = zz[j];
        }
        final PrintWriter pw = new PrintWriter(System.out);
        final PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
        pq.offer(new long[] { revXy[0] + revZ[0], 0, 0 });
        for (int i = 0; i < k; i++) {
            final long[] curr = pq.remove();
            final int l = (int) curr[1];
            final int r = (int) curr[2];
            pw.println(curr[0]);
            add(revXy, revZ, l, r + 1, pq);
            if (r == 0) {
                add(revXy, revZ, l + 1, 0, pq);
            }
        }
        pw.close();
    }

    private static void add(long[] xy, long[] z, int i, int j, PriorityQueue<long[]> pq) {
        if (i < xy.length && j < z.length) {
            pq.offer(new long[] { xy[i] + z[j], i, j });
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
