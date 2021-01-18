package atcoder.beginner_100_199.beginner_152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final Map<Integer, List<int[]>> g = new HashMap<>();
        for (int i = 0; i < (n - 1); i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            g.computeIfAbsent(u, val -> new ArrayList<>()).add(new int[] { v, i });
            g.computeIfAbsent(v, val -> new ArrayList<>()).add(new int[] { u, i });
        }
        final int m = fs.nextInt();
        final int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i] = new int[] { fs.nextInt() - 1, fs.nextInt() - 1 };
        }
        final long[] masks = new long[m];
        for (int i = 0; i < m; i++) {
            final int[] e = edges[i];
            final long[] mask = { 0L };
            dfs(new int[] { e[0], -1 }, -1, e[1], mask, g);
            masks[i] = mask[0];
        }
        long res = 0L;
        for (int i = 0; i < (1 << m); i++) {
            long mask = 0L;
            for (int j = 0; j < m; j++) {
                if ((i & (1 << j)) != 0) {
                    mask |= masks[j];
                }
            }
            final int white = Long.bitCount(mask);
            final long curr = 1L << (n - 1 - white);
            // https://en.wikipedia.org/wiki/Inclusion%E2%80%93exclusion_principle
            // Inclusion/Exclusion deciding factor!!
            // Subtract all odds, add all evens - easily checked by bit count parity
            // 001 -> 1
            // 010 -> 1
            // 011 -> 2
            // 100 -> 1
            // 101 -> 2
            // 110 -> 2
            // 111 -> 3
            if (Integer.bitCount(i) % 2 == 0) {
                res += curr;
            } else {
                res -= curr;
            }
        }
        System.out.println(res);
    }

    private static boolean dfs(int[] u, int v, int tar, long[] mask, Map<Integer, List<int[]>> g) {
        if (v != -1) { mask[0] = mask[0] ^= 1L << u[1]; }
        if (tar == u[0]) {
            return true;
        }
        for (int[] next : g.getOrDefault(u[0], Collections.emptyList())) {
            if (next[0] != v) {
                if (dfs(next, u[0], tar, mask, g)) {
                    return true;
                }
            }
        }
        if (v != -1) { mask[0] = mask[0] ^= 1L << u[1]; }
        return false;
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
