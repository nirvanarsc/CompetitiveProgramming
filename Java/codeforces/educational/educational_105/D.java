package codeforces.educational.educational_105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[][] g = new int[1005][1005];
        final boolean[] seen = new boolean[1005];
        final List<int[]> edges = new ArrayList<>();
        final List<Integer> c = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = fs.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            c.add(g[i][i]);
        }
        int idx = n;
        while (true) {
            final List<Integer> all = new ArrayList<>();
            for (int i = 0; i < idx; i++) {
                if (!seen[i]) {
                    all.add(i);
                }
            }
            final int m = all.size();
            if (m == 1) {
                break;
            }
            int v = -1;
            int best = (int) 1e9;
            for (int i = 0; i < m; i++) {
                for (int j = i + 1; j < m; j++) {
                    if (g[all.get(i)][all.get(j)] < best) {
                        best = g[all.get(i)][all.get(j)];
                        v = all.get(i);
                    }
                }
            }
            c.add(best);
            edges.add(new int[] { v, idx });
            seen[v] = true;
            for (int u : all) {
                g[u][idx] = g[idx][u] = g[u][v];
                if (g[v][u] == best) {
                    edges.add(new int[] { u, idx });
                    seen[u] = true;
                }
            }
            idx++;
        }
        System.out.println(idx);
        for (int i = 0; i < idx; i++) {
            System.out.printf("%d ", c.get(i));
        }
        System.out.println();
        for (int i = 0; i < idx; i++) {
            if (!seen[i]) {
                System.out.printf("%d\n", i + 1);
            }
        }
        for (int i = 0; i < (idx - 1); i++) {
            System.out.printf("%d %d\n", edges.get(i)[0] + 1, edges.get(i)[1] + 1);
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
