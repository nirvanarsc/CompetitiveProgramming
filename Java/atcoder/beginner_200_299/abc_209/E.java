package atcoder.beginner_200_299.abc_209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

public final class E {

    static Map<String, Integer> dp;
    static Map<String, List<String>> g;

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fs.next();
        }
        final Set<String> uniq = new HashSet<>();
        g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (uniq.add(arr[i])) {
                g.computeIfAbsent(arr[i].substring(0, 3), val -> new ArrayList<>()).add(arr[i]);
            }
        }
        final Set<String> cycle = new HashSet<>();
        final Set<String> explored = new HashSet<>();
        for (String ff : arr) {
            if (!cycle.contains(ff) && !explored.contains(ff)) {
                final Set<String> seen = new HashSet<>();
                if (dfs(ff, seen, cycle)) {
                    cycle.addAll(seen);
                } else {
                    explored.addAll(seen);
                }
            }
        }
        dp = new HashMap<>();
        for (String ff : arr) {
            if (!cycle.contains(ff)) {
                dfs2(ff, 0);
            }
        }
        for (int i = 0; i < n; i++) {
            if (cycle.contains(arr[i])) {
                System.out.println("Draw");
                continue;
            }
            if (!dp.containsKey(arr[i])) {
                System.out.println("Takahashi");
            } else {
                System.out.println(dp.get(arr[i]) == 0 ? "Takahashi" : "Aoki");
            }
        }
    }

    private static int dfs2(String s, int turn) {
        final String last3 = s.substring(s.length() - 3);
        if (!g.containsKey(last3)) {
            return turn;
        }
        if (dp.containsKey(s)) {
            return dp.get(s);
        }
        int res = turn == 0 ? 1 : 0;
        for (String next : g.get(last3)) {
            if (turn == 0) {
                res = Math.min(res, dfs2(next, 1));
            } else {
                res = Math.max(res, dfs2(next, 0));
            }
        }
        dp.put(s, res);
        return res;
    }

    private static boolean dfs(String s, Set<String> seen, Set<String> cycle) {
        final String last3 = s.substring(s.length() - 3);
        if (!g.containsKey(last3)) {
            return false;
        }
        if (!seen.add(s) || cycle.contains(s)) {
            return true;
        }
        for (String next : g.get(last3)) {
            if (dfs(next, seen, cycle)) {
                return true;
            }
        }
        return false;
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
