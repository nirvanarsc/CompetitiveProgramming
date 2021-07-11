package kickstart.year_2021.round_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class A {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int x = 1; x <= t; x++) {
            final int[][] g = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    g[i][j] = fs.nextInt();
                }
            }
            int other = 0;
            if (g[0][1] - g[0][0] == g[0][2] - g[0][1]) {
                other++;
            }
            if (g[2][1] - g[2][0] == g[2][2] - g[2][1]) {
                other++;
            }
            if (g[1][0] - g[0][0] == g[2][0] - g[1][0]) {
                other++;
            }
            if (g[1][2] - g[0][2] == g[2][2] - g[1][2]) {
                other++;
            }
            final List<int[]> test = new ArrayList<>();
            test.add(new int[] { g[0][0], g[2][2] });
            test.add(new int[] { g[2][0], g[0][2] });
            test.add(new int[] { g[1][0], g[1][2] });
            test.add(new int[] { g[0][1], g[2][1] });
            int max = 0;
            for (int[] tt : test) {
                if ((tt[1] - tt[0]) % 2 == 0) {
                    int curr = 0;
                    final int mid = tt[0] + (tt[1] - tt[0]) / 2;
                    for (int[] zz : test) {
                        if (mid - zz[0] == zz[1] - mid) {
                            curr++;
                        }
                    }
                    max = Math.max(max, curr);
                }
            }
            System.out.println("Case #" + x + ": " + (other + max));
        }
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
