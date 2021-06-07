package atcoder.beginner_200_299.abc_204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final Map<Integer, List<int[]>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            g.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            final int c = fs.nextInt();
            final int d = fs.nextInt();
            g.get(u).add(new int[] { v, c, d });
            g.get(v).add(new int[] { u, c, d });
        }
        final PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(val -> val[1]));
        pq.offer(new long[] { 0, 0 });
        final long[] dist = new long[n];
        Arrays.fill(dist, (long) 1e18);
        dist[0] = 0;
        while (!pq.isEmpty()) {
            final long[] curr = pq.remove();
            final int u = (int) curr[0];
            final long t = curr[1];
            if (dist[u] < t) {
                continue;
            }
            for (int[] next : g.get(u)) {
                final int v = next[0];
                final int c = next[1];
                final int d = next[2];
                final long nextT = Math.max(t, (int) Math.sqrt(d));
                final long nextD = nextT + c + f(d, nextT);
                if (dist[v] > nextD) {
                    dist[v] = nextD;
                    pq.offer(new long[] { v, nextD });
                }
            }
        }
        System.out.println(dist[n - 1] == (long) 1e18 ? -1 : dist[n - 1]);
    }

    private static long f(long d, long t) {
        return d / (t + 1);
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
