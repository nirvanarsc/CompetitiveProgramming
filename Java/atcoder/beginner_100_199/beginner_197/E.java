package atcoder.beginner_100_199.beginner_197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[][] g = new int[n][2];
        for (int i = 0; i < n; i++) {
            g[i] = new int[] { (int) 1e9, (int) -1e9 };
        }
        final boolean[] all = new boolean[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            final int x = fs.nextInt();
            final int c = fs.nextInt() - 1;
            g[c][0] = Math.min(g[c][0], x);
            g[c][1] = Math.max(g[c][1], x);
            if (!all[c]) {
                total++;
                all[c] = true;
            }
        }
        int idx = 0;
        final int[][] gg = new int[total][2];
        for (int i = 0; i < n; i++) {
            if (all[i]) {
                gg[idx++] = g[i];
            }
        }
        System.out.println(dfs(gg, 0, 0, new HashMap<>()));
    }

    private static long dfs(int[][] g, int pos, int c, Map<Integer, Long> dp) {
        if (c == g.length) {
            return Math.abs(pos);
        }
        if (dp.containsKey(pos)) {
            return dp.get(pos);
        }
        long res = (long) 1e18;
        if (pos < g[c][0]) {
            res = Math.min(res, (g[c][1] - pos) + dfs(g, g[c][1], c + 1, dp));
        } else if (g[c][0] < pos && pos < g[c][1]) {
            res = Math.min(res, 2L * (pos - g[c][0]) + (g[c][1] - pos) + dfs(g, g[c][1], c + 1, dp));
            res = Math.min(res, 2L * (g[c][1] - pos) + (pos - g[c][0]) + dfs(g, g[c][0], c + 1, dp));
        } else {
            res = Math.min(res, pos - g[c][0] + dfs(g, g[c][0], c + 1, dp));
        }
        dp.put(pos, res);
        return res;
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
