package atcoder.beginner_200_299.abc_211;

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

public final class D {

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final List<List<int[]>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            final int w = 1;
            g.get(u).add(new int[] { v, w });
            g.get(v).add(new int[] { u, w });
        }
        final PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(val -> val[0]));
        pq.offer(new long[] { 0, 0 });
        final long[] d = new long[n];
        final long[] num = new long[n];
        final int[] minf = new int[n];
        final int[] maxf = new int[n];
        final boolean[] seen = new boolean[n];
        Arrays.fill(d, (long) 1e18);
        d[0] = 0;
        num[0] = 1;
        while (!pq.isEmpty()) {
            final long[] curr = pq.remove();
            final long w = curr[0];
            final int u = (int) curr[1];
            if (seen[u]) {
                continue;
            }
            seen[u] = true;
            for (int[] next : g.get(u)) {
                final long nextW = w + next[1];
                if (nextW == d[next[0]]) {
                    num[next[0]] = (num[next[0]] + num[u]) % MOD;
                    minf[next[0]] = Math.min(minf[next[0]], minf[u] + 1);
                    maxf[next[0]] = Math.max(maxf[next[0]], maxf[u] + 1);
                    pq.add(new long[] { nextW, next[0] });
                } else if (nextW < d[next[0]]) {
                    d[next[0]] = nextW;
                    num[next[0]] = num[u];
                    minf[next[0]] = minf[u] + 1;
                    maxf[next[0]] = maxf[u] + 1;
                    pq.add(new long[] { nextW, next[0] });
                }
            }
        }
        System.out.println(num[n - 1]);
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
