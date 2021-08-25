package codeforces.round_700_749.round_740;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final StringBuilder sb = new StringBuilder();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                final int L = fs.nextInt();
                final int[] curr = fs.nextIntArray(L);
                int max = 0;
                for (int j = 0; j < L; j++) {
                    max = Math.max(max, curr[j] - j + 1);
                }
                arr[i] = new int[] { max, L };
            }
            Arrays.sort(arr, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1])
                                                    : Integer.compare(a[0], b[0]));
            int lo = 1;
            int hi = (int) 1e9 + 5;
            while (lo < hi) {
                final int mid = lo + hi >>> 1;
                if (!f(arr, mid)) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            sb.append(lo).append('\n');
        }
        System.out.println(sb);
    }

    private static boolean f(int[][] arr, int mid) {
        long curr = mid;
        for (int[] cave : arr) {
            if (curr < cave[0]) {
                return false;
            }
            curr += cave[1];
        }
        return true;
    }

    static final class Utils {
        private static class Shuffler {
            private static void shuffle(int[] x) {
                final Random r = new Random();

                for (int i = 0; i <= x.length - 2; i++) {
                    final int j = i + r.nextInt(x.length - i);
                    swap(x, i, j);
                }
            }

            private static void shuffle(long[] x) {
                final Random r = new Random();

                for (int i = 0; i <= x.length - 2; i++) {
                    final int j = i + r.nextInt(x.length - i);
                    swap(x, i, j);
                }
            }

            private static void swap(int[] x, int i, int j) {
                final int t = x[i];
                x[i] = x[j];
                x[j] = t;
            }

            private static void swap(long[] x, int i, int j) {
                final long t = x[i];
                x[i] = x[j];
                x[j] = t;
            }
        }

        public static void shuffleSort(int[] arr) {
            Shuffler.shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffleSort(long[] arr) {
            Shuffler.shuffle(arr);
            Arrays.sort(arr);
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
