package codeforces.round_700_749.round_703;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            final int w = fs.nextInt();
            g.get(u).add(new int[] { v, w });
            g.get(v).add(new int[] { u, w });
        }
        final int[][] d = new int[n][55];
        final int inf = (int) 2e9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 50; j++) {
                d[i][j] = inf;
            }
        }
        d[0][0] = 0;
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(val -> val[0]));
        pq.offer(new int[] { 0, 0, 0 });
        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            final int u = curr[1];
            final int w = curr[2];
            if (curr[0] > d[u][w]) {
                continue;
            }
            for (int[] next : g.get(u)) {
                final int v = next[0];
                final int w1 = next[1];
                int nw = 0;
                final int total;
                if (w == 0) {
                    nw = w1;
                    total = d[u][0];
                } else {
                    total = d[u][w] + (w1 + w) * (w1 + w);
                }
                if (total < d[v][nw]) {
                    d[v][nw] = total;
                    pq.offer(new int[] { total, v, nw });
                }
            }
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(d[i][0] == inf ? -1 : d[i][0]);
            sb.append(' ');
        }
        System.out.println(sb);
    }

    static final class Utils {
        public static void shuffleSort(int[] x) {
            shuffle(x);
            Arrays.sort(x);
        }

        public static void shuffleSort(long[] x) {
            shuffle(x);
            Arrays.sort(x);
        }

        public static void shuffle(int[] x) {
            final Random r = new Random();

            for (int i = 0; i <= x.length - 2; i++) {
                final int j = i + r.nextInt(x.length - i);
                swap(x, i, j);
            }
        }

        public static void shuffle(long[] x) {
            final Random r = new Random();

            for (int i = 0; i <= x.length - 2; i++) {
                final int j = i + r.nextInt(x.length - i);
                swap(x, i, j);
            }
        }

        public static void swap(int[] x, int i, int j) {
            final int t = x[i];
            x[i] = x[j];
            x[j] = t;
        }

        public static void swap(long[] x, int i, int j) {
            final long t = x[i];
            x[i] = x[j];
            x[j] = t;
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
