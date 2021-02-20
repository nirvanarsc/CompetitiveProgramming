package atcoder.beginner_100_199.beginner_192;

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
        final int x = fs.nextInt() - 1;
        final int y = fs.nextInt() - 1;
        final List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            final int t = fs.nextInt();
            final int k = fs.nextInt();
            g.get(u).add(new int[] { v, t, k });
            g.get(v).add(new int[] { u, t, k });
        }
        final PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(val -> val[0]));
        pq.offer(new long[] { 0, x });
        final long[] d = new long[n];
        Arrays.fill(d, (long) 1e18);
        d[x] = 0;
        while (!pq.isEmpty()) {
            final long[] remove = pq.remove();
            final long time = remove[0];
            final int u = (int) remove[1];
            if (time > d[u]) {
                continue;
            }
            for (int[] next : g.get(u)) {
                long wait = 0;
                if (time % next[2] != 0) {
                    wait = next[2] - time % next[2];
                }
                final long nc = time + wait + next[1];
                if (nc < d[next[0]]) {
                    d[next[0]] = nc;
                    pq.offer(new long[] { time + wait + next[1], next[0] });
                }
            }
        }
        System.out.println(d[y] != (long) 1e18 ? d[y] : -1);
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
