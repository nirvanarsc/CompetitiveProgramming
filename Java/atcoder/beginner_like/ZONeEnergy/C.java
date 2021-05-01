package atcoder.beginner_like.ZONeEnergy;

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
        final int[][] g = new int[n][5];
        final List<int[]> a = new ArrayList<>(n);
        final List<int[]> b = new ArrayList<>(n);
        final List<int[]> c = new ArrayList<>(n);
        final List<int[]> d = new ArrayList<>(n);
        final List<int[]> e = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g[i] = new int[] { fs.nextInt(), fs.nextInt(), fs.nextInt(), fs.nextInt(), fs.nextInt() };
            a.add(new int[] { i, g[i][0] });
            b.add(new int[] { i, g[i][1] });
            c.add(new int[] { i, g[i][2] });
            d.add(new int[] { i, g[i][3] });
            e.add(new int[] { i, g[i][4] });
        }
        a.sort((l, r) -> Integer.compare(r[1], l[1]));
        b.sort((l, r) -> Integer.compare(r[1], l[1]));
        c.sort((l, r) -> Integer.compare(r[1], l[1]));
        d.sort((l, r) -> Integer.compare(r[1], l[1]));
        e.sort((l, r) -> Integer.compare(r[1], l[1]));
        final int[] test = { a.get(0)[0], b.get(0)[0], c.get(0)[0], d.get(0)[0], e.get(0)[0] };
        int max = 0;
        for (int first : test) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (first != i && first != j && i != j) {
                        int curr = (int) 2e9;
                        for (int k = 0; k < 5; k++) {
                            final int skill = Math.max(g[first][k], Math.max(g[i][k], g[j][k]));
                            curr = Math.min(curr, skill);
                        }
                        max = Math.max(curr, max);
                    }
                }
            }
        }
        System.out.println(max);
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
