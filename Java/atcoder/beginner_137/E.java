package atcoder.beginner_137;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int p = fs.nextInt();
        final List<int[]> edges = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            // Mark negative to find negative cycles
            final int w = (fs.nextInt() - p) * -1;
            edges.add(new int[] { u, v, w });
        }
        final long[] dist = bellmanFord(edges, 0, n);
        if (dist[n - 1] == (long) -1e18) {
            System.out.println(-1);
        } else {
            System.out.println(Math.max(0, -dist[n - 1]));
        }
    }

    // Bellman-Ford O (V*E) == O(V^3)
    private static long[] bellmanFord(List<int[]> e, int start, int n) {
        final long[] dist = new long[n];
        Arrays.fill(dist, (long) 1e18);
        dist[start] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : e) {
                final int from = edge[0];
                final int to = edge[1];
                final int cost = edge[2];
                if (dist[from] == (long) 1e18) {
                    continue;
                }
                dist[to] = Math.min(dist[to], dist[from] + cost);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : e) {
                final int from = edge[0];
                final int to = edge[1];
                final int cost = edge[2];
                if (dist[from] == (long) 1e18) {
                    continue;
                }
                if (dist[from] + cost < dist[to]) {
                    dist[to] = (long) -1e18;
                }
            }
        }
        return dist;
    }

    static final class Utils {
        public static void shuffleSort(int[] arr) {
            shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffleSort(long[] arr) {
            shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffle(int[] arr) {
            final Random r = new Random();

            for (int i = 0; i <= arr.length - 2; i++) {
                final int j = i + r.nextInt(arr.length - i);
                swap(arr, i, j);
            }
        }

        public static void shuffle(long[] arr) {
            final Random r = new Random();

            for (int i = 0; i <= arr.length - 2; i++) {
                final int j = i + r.nextInt(arr.length - i);
                swap(arr, i, j);
            }
        }

        public static void swap(int[] arr, int i, int j) {
            final int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

        public static void swap(long[] arr, int i, int j) {
            final long t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
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
