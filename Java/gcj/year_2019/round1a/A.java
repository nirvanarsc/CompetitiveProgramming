package gcj.year_2019.round1a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class A {

    static int n;
    static int m;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        final StringBuilder sb = new StringBuilder();
        for (int test = 1; test <= t; test++) {
            n = fs.nextInt();
            m = fs.nextInt();
            final List<int[]> res = new ArrayList<>();
            final boolean[][] seen = new boolean[n][m];
            outer:
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visit(res, seen, i, j)) {
                        break outer;
                    }
                }
            }
            sb.append("Case #" + test + ": " + (res.isEmpty() ? "IMPOSSIBLE" : "POSSIBLE"));
            sb.append('\n');
            if (!res.isEmpty()) {
                for (int[] ee : res) {
                    sb.append(ee[0] + 1);
                    sb.append(' ');
                    sb.append(ee[1] + 1);
                    sb.append('\n');
                }
            }
        }
        System.out.println(sb);
    }

    private static boolean visit(List<int[]> q, boolean[][] seen, int i, int j) {
        if (q.size() == n * m) {
            return true;
        }
        if (seen[i][j]) {
            return false;
        }
        seen[i][j] = true;
        q.add(new int[] { i, j });
        final List<int[]> next = getNext(i, j);
//        Collections.shuffle(next);
        for (int[] v : next) {
            if (visit(q, seen, v[0], v[1])) {
                return true;
            }
        }
        seen[i][j] = false;
        q.remove(q.size() - 1);
        return false;
    }

    private static List<int[]> getNext(int i, int j) {
        final List<int[]> res = new ArrayList<>();
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < m; l++) {
                if (k != i && l != j && (i - j) != (k - l) && (i + j) != (k + l)) {
                    res.add(new int[] { k, l });
                }
            }
        }
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
