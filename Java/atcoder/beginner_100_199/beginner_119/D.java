package atcoder.beginner_100_199.beginner_119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int a = fs.nextInt();
        final int b = fs.nextInt();
        final int q = fs.nextInt();
        final TreeSet<Long> shrines = new TreeSet<>();
        final TreeSet<Long> temples = new TreeSet<>();
        for (int i = 0; i < a; i++) {
            shrines.add(fs.nextLong());
        }
        for (int i = 0; i < b; i++) {
            temples.add(fs.nextLong());
        }
        for (int i = 0; i < q; i++) {
            final long pos = fs.nextLong();
            long currAns = (long) 1e18;
            final Long leftShrine = shrines.floor(pos);
            final Long leftTemple = temples.floor(pos);
            final Long rightShrine = shrines.ceiling(pos);
            final Long rightTemple = temples.ceiling(pos);
            // left left
            if (leftShrine != null && leftTemple != null) {
                currAns = Math.min(currAns, pos - Math.min(leftShrine, leftTemple));
            }
            // right right
            if (rightShrine != null && rightTemple != null) {
                currAns = Math.min(currAns, Math.max(rightShrine, rightTemple) - pos);
            }
            // right left
            if (rightShrine != null && leftTemple != null) {
                currAns = Math.min(currAns,
                                   Math.min(2 * rightShrine - pos - leftTemple,
                                            rightShrine + pos - 2 * leftTemple));
            }
            // right left
            if (rightTemple != null && leftShrine != null) {
                currAns = Math.min(currAns,
                                   Math.min(2 * rightTemple - pos - leftShrine,
                                            rightTemple + pos - 2 * leftShrine));
            }
            pw.println(currAns);
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
