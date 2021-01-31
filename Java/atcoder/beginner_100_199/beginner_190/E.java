package atcoder.beginner_100_199.beginner_190;

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
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt();
            final int v = fs.nextInt();
            g.computeIfAbsent(u, val -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
        }
        final int k = fs.nextInt();
        final int[] arr = fs.nextIntArray(k);
        final int[][] dist = new int[n + 5][k];
        for (int[] row : dist) {
            Arrays.fill(row, (int) 1e9);
        }
        for (int i = 0; i < k; i++) {
            bfs(i, g, dist, arr);
        }
        for (int i = 0; i < k; i++) {
            if (dist[arr[0]][i] == (int) 1e9) {
                System.out.println(-1);
                return;
            }
        }
        final int[][] dp = new int[k][1 << k];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(1 + dfs(arr, -1, 0, k, dist, dp));
    }

    private static int dfs(int[] arr, int prev, int mask, int k, int[][] dist, int[][] dp) {
        if (mask == ((1 << k) - 1)) {
            return 0;
        }
        if (prev != -1 && dp[prev][mask] != -1) {
            return dp[prev][mask];
        }
        int res = (int) 1e9;
        for (int i = 0; i < k; i++) {
            if ((mask & (1 << i)) == 0) {
                final int cost = prev == -1 ? 0 : dist[arr[prev]][i];
                res = Math.min(res, dfs(arr, i, mask | (1 << i), k, dist, dp) + cost);
            }
        }
        if (prev != -1) {
            dp[prev][mask] = res;
        }
        return res;
    }

    private static void bfs(int u, Map<Integer, List<Integer>> g, int[][] dist, int[] arr) {
        final Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(arr[u]);
        dist[arr[u]][u] = 0;
        while (!q.isEmpty()) {
            final int curr = q.removeFirst();
            for (int next : g.getOrDefault(curr, Collections.emptyList())) {
                if (dist[next][u] == (int) 1e9) {
                    dist[next][u] = dist[curr][u] + 1;
                    q.offerLast(next);
                }
            }
        }
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
