package codeforces.round_700_749.round_733;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        final StringBuilder sb = new StringBuilder();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt() - 1;
            }
            boolean[] seen = new boolean[n];
            for (int i = 0; i < n; i++) {
                seen[arr[i]] = true;
            }
            final Deque<Integer> notSeen = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (!seen[i]) {
                    notSeen.addLast(i);
                }
            }
            final Set<String> zz = new HashSet<>();
            seen = new boolean[n];
            for (int u : notSeen) {
                dfs(arr, seen, u, zz);
            }
            int ok = 0;
            final TreeSet<Integer> bad = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                if (seen[i]) {
                    ok++;
                } else {
                    bad.add(i);
                }
            }
            sb.append(ok).append('\n');
            for (int i = 0; i < n; i++) {
                if (zz.contains(i + "," + arr[i])) {
                    sb.append(arr[i] + 1).append(' ');
                } else {
                    int curr;
                    int top = bad.pollLast();
                    if (top == i) {
                        curr = bad.pollLast();
                        bad.add(top);
                    } else {
                        curr = top;
                    }
                    sb.append(curr + 1).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int[] arr, boolean[] seen, int i, Set<String> zz) {
        if (seen[arr[i]]) {
            return;
        }
        seen[arr[i]] = true;
        zz.add(i + "," + arr[i]);
        dfs(arr, seen, arr[i], zz);
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
