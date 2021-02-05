package atcoder.beginner_100_199.beginner_164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int s = Math.min(2999, fs.nextInt());
        final List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            final int a = fs.nextInt();
            final int b = fs.nextInt();
            g.get(u).add(new int[] { v, a, b });
            g.get(v).add(new int[] { u, a, b });
        }
        final int[][] trade = new int[n][2];
        for (int i = 0; i < n; i++) {
            trade[i] = new int[] { fs.nextInt(), fs.nextInt() };
        }
        final long[][] dp = new long[n][3000];
        for (long[] row : dp) {
            Arrays.fill(row, (long) 1e18);
        }
        final PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(val -> val[0]));
        pq.offer(new long[] { 0, 0, s });
        while (!pq.isEmpty()) {
            final long[] curr = pq.remove();
            final long val = curr[0];
            final int u = (int) curr[1];
            final int currS = (int) curr[2];
            if (val > dp[u][currS]) {
                continue;
            }
            for (int[] next : g.get(u)) {
                if (currS >= next[1]) {
                    add(dp, pq, next[0], currS - next[1], val + next[2]);
                }
            }
            if (currS + trade[u][0] < 3000) {
                add(dp, pq, u, currS + trade[u][0], val + trade[u][1]);
            }
        }
        for (int i = 1; i < n; i++) {
            long res = (long) 1e18;
            for (int j = 0; j < 3000; j++) {
                res = Math.min(res, dp[i][j]);
            }
            pw.println(res);
        }
        pw.close();
    }

    private static void add(long[][] dp, PriorityQueue<long[]> pq, int nextU, int nextS, long nextVal) {
        if (dp[nextU][nextS] > nextVal) {
            dp[nextU][nextS] = nextVal;
            pq.offer(new long[] { nextVal, nextU, nextS });
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
