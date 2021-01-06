package codeforces.round_650_699.round_693;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class F {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int m = fs.nextInt();
            final List<int[]> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                final int u = fs.nextInt();
                final int v = fs.nextInt();
                list.add(new int[] { u, v });
            }
            list.sort(Comparator.comparingInt(a -> a[1]));
            final List<int[]> masks = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                final int[] l = list.get(i);
                if (i < list.size() - 1 && list.get(i + 1)[1] == l[1]) {
                    masks.add(new int[] { 3, l[1] });
                    i++;
                } else {
                    masks.add(l);
                }
            }
            int prevC = 1;
            final List<Integer> arr = new ArrayList<>();
            for (int[] mask : masks) {
                f(mask[1], prevC, arr);
                arr.add(mask[0]);
                prevC = mask[1] + 1;
            }
            f(n + 1, prevC, arr);
            final boolean ok = dfs(arr, 0, 0, new Boolean[arr.size()][4]);
            System.out.println(ok ? "YES" : "NO");
        }
    }

    private static boolean dfs(List<Integer> arr, int idx, int mask, Boolean[][] dp) {
        if (idx == arr.size()) {
            return mask == 3;
        }
        if (dp[idx][mask] != null) {
            return dp[idx][mask];
        }
        boolean res = false;
        if (arr.get(idx) == 2) {
            if (mask == 0 || mask == 3) {
                res = dfs(arr, idx + 1, 2, dp);
            } else if (mask == 2) {
                res = dfs(arr, idx + 1, 3, dp);
            }
        } else if (arr.get(idx) == 1) {
            if (mask == 0 || mask == 3) {
                res = dfs(arr, idx + 1, 1, dp);
            } else if (mask == 1) {
                res = dfs(arr, idx + 1, 3, dp);
            }
        } else if (arr.get(idx) == 0) {
            if (mask == 0 || mask == 3) {
                res = dfs(arr, idx + 1, 0, dp) || dfs(arr, idx + 1, 3, dp);
            } else if (mask == 1) {
                res = dfs(arr, idx + 1, 2, dp);
            } else if (mask == 2) {
                res = dfs(arr, idx + 1, 1, dp);
            }
        } else {
            if (mask == 0 || mask == 3) {
                res = dfs(arr, idx + 1, 3, dp);
            }
        }
        return dp[idx][mask] = res;
    }

    private static void f(int n, int prevC, List<Integer> arr) {
        int last = n - prevC;
        if (last > 4) {
            last = 4 - last % 2;
        }
        for (int i = 0; i < last; i++) {
            arr.add(0);
        }
    }

    static final class Utils {
        public static void shuffleSort(int[] x) {
            shuffle(x);
            Arrays.sort(x);
        }

        public static void shuffleSort(long[] x) {
            shuffle(x);
            Arrays.sort(x);
        }

        public static void shuffle(int[] x) {
            final Random r = new Random();

            for (int i = 0; i <= x.length - 2; i++) {
                final int j = i + r.nextInt(x.length - i);
                swap(x, i, j);
            }
        }

        public static void shuffle(long[] x) {
            final Random r = new Random();

            for (int i = 0; i <= x.length - 2; i++) {
                final int j = i + r.nextInt(x.length - i);
                swap(x, i, j);
            }
        }

        public static void swap(int[] x, int i, int j) {
            final int t = x[i];
            x[i] = x[j];
            x[j] = t;
        }

        public static void swap(long[] x, int i, int j) {
            final long t = x[i];
            x[i] = x[j];
            x[j] = t;
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
