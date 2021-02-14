package atcoder.regular_100_199.regular_112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 1; i < n; i++) {
            final int u = fs.nextInt() - 1;
            g.computeIfAbsent(i, val -> new ArrayList<>()).add(u);
            g.computeIfAbsent(u, val -> new ArrayList<>()).add(i);
        }
        final int[] dp = new int[n];
        final int[] size = new int[n];
        dfs(0, -1, g, dp, size);
        System.out.println((n + dp[0]) / 2);
    }

    private static void dfs(int u, int v, Map<Integer, List<Integer>> g, int[] dp, int[] size) {
        int sum = 0;
        dp[u] = 1;
        size[u] = 1;
        final List<Integer> seq = new ArrayList<>();
        for (int next : g.getOrDefault(u, Collections.emptyList())) {
            if (next != v) {
                dfs(next, u, g, dp, size);
                size[u] += size[next];
                if (size[next] % 2 != 0) {
                    // case 3
                    seq.add(-dp[next]);
                } else {
                    if (dp[next] < 0) {
                        // case 1
                        dp[u] -= -dp[next];
                    } else {
                        // case 2
                        sum -= dp[next];
                    }
                }
            }
        }
        seq.sort(Comparator.reverseOrder());
        seq.add(sum);
        for (int i = 0; i < seq.size(); ++i) {
            if (i % 2 != 0) {
                dp[u] += seq.get(i);
            } else {
                dp[u] -= seq.get(i);
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
