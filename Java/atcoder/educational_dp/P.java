package atcoder.educational_dp;

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

public final class P {

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            final int u = fs.nextInt();
            final int v = fs.nextInt();
            g.computeIfAbsent(u, adj -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, adj -> new ArrayList<>()).add(u);
        }
        final long[] res = dfs(1, -1, g);
        System.out.println((res[0] + res[1]) % MOD);
    }

    private static long[] dfs(int curr, int par, Map<Integer, List<Integer>> g) {
        long paintBlack = 1;
        long paintWhite = 0;
        for (int next : g.getOrDefault(curr, Collections.emptyList())) {
            if (next != par) {
                // left = # of ways to color the subtree such that next is black
                // right = # of ways to color the subtree such that next is white
                final long[] dfs = dfs(next, curr, g);
                final long copyPaintBlack = paintBlack;
                paintBlack = (paintBlack * dfs[1]) % MOD;
                paintWhite = ((copyPaintBlack * dfs[0]) % MOD + (paintWhite * (dfs[0] + dfs[1])) % MOD) % MOD;
            }
        }
        return new long[] { paintBlack, (paintBlack + paintWhite) % MOD };
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
