package codeforces.round_636;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int m = fs.nextInt();
            final int a = fs.nextInt() - 1;
            final int b = fs.nextInt() - 1;
            final int c = fs.nextInt() - 1;
            final int[] price = fs.nextIntArray(m);
            Utils.shuffleSort(price);
            final long[] prefix = new long[m + 1];
            for (int i = 0; i < m; i++) {
                prefix[i + 1] = prefix[i] + price[i];
            }
            final Map<Integer, List<Integer>> g = new HashMap<>();
            for (int i = 0; i < m; i++) {
                final int u = fs.nextInt() - 1;
                final int v = fs.nextInt() - 1;
                g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
                g.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
            }
            final int[] da = bfs(a, g, n);
            final int[] db = bfs(b, g, n);
            final int[] dc = bfs(c, g, n);
            long res = (long) 1e18;
            for (int i = 0; i < n; i++) {
                if (da[i] + db[i] + dc[i] <= m) {
                    res = Math.min(res, prefix[db[i]] + prefix[da[i] + db[i] + dc[i]]);
                }
            }
            System.out.println(res);
        }
    }

    private static int[] bfs(int start, Map<Integer, List<Integer>> g, int n) {
        final Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(start);
        final int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        while (!q.isEmpty()) {
            final int curr = q.removeFirst();
            for (int next : g.getOrDefault(curr, Collections.emptyList())) {
                if (dist[next] == Integer.MAX_VALUE) {
                    dist[next] = dist[curr] + 1;
                    q.offerLast(next);
                }
            }
        }
        return dist;
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
