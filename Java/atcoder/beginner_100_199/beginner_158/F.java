package atcoder.beginner_100_199.beginner_158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[][] p = new int[n][2];
        for (int i = 0; i < n; i++) {
            p[i] = new int[] { fs.nextInt(), fs.nextInt() };
        }
        Arrays.sort(p, Comparator.comparingInt(a -> a[0]));
        final Map<Integer, List<Integer>> g = new HashMap<>();
        final Deque<int[]> dq = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            final int x = p[i][0];
            final int d = p[i][1];
            while (!dq.isEmpty() && dq.getFirst()[0] < x + d) {
                g.computeIfAbsent(i, val -> new ArrayList<>()).add(dq.removeFirst()[1]);
            }
            dq.addFirst(new int[] { x, i });
        }
        long res = 1;
        for (int[] root : dq) {
            res = (res * dfs(root[1], g)) % MOD;
        }
        System.out.println(res);
    }

    private static long dfs(int idx, Map<Integer, List<Integer>> g) {
        long res = 1;
        for (int next : g.getOrDefault(idx, Collections.emptyList())) {
            res = (res * dfs(next, g)) % MOD;
        }
        return (res + 1) % MOD;
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
