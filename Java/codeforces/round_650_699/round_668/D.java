package codeforces.round_650_699.round_668;

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

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int a = fs.nextInt() - 1;
            final int b = fs.nextInt() - 1;
            final int da = fs.nextInt();
            final int db = fs.nextInt();
            final Map<Integer, List<Integer>> g = new HashMap<>();
            for (int i = 1; i < n; i++) {
                final int l = fs.nextInt() - 1;
                final int r = fs.nextInt() - 1;
                g.computeIfAbsent(l, v -> new ArrayList<>()).add(r);
                g.computeIfAbsent(r, v -> new ArrayList<>()).add(l);
            }
            final int bobDistance = bobDistance(g, new boolean[n], a, b);
            if (bobDistance <= da) {
                System.out.println("Alice");
                continue;
            }
            final int[] furthest = bfs(g, new boolean[n], a);
            final int diameter = bfs(g, new boolean[n], furthest[1])[0];
            if (2 * da >= diameter) {
                System.out.println("Alice");
            } else if (2 * da < db) {
                System.out.println("Bob");
            } else {
                System.out.println("Alice");
            }
        }
    }

    private static int bobDistance(Map<Integer, List<Integer>> g, boolean[] seen, int alice, int bob) {
        final Deque<Integer> q = new ArrayDeque<>(Collections.singletonList(alice));
        for (int level = 0; !q.isEmpty(); level++) {
            for (int size = q.size(); size > 0; size--) {
                final Integer curr = q.removeFirst();
                if (curr == bob) {
                    return level;
                }
                if (seen[curr]) {
                    continue;
                }
                seen[curr] = true;

                for (int next : g.getOrDefault(curr, Collections.emptyList())) {
                    q.offerLast(next);
                }
            }
        }
        return -1;
    }

    private static int[] bfs(Map<Integer, List<Integer>> g, boolean[] seen, int from) {
        final Deque<Integer> q = new ArrayDeque<>(Collections.singletonList(from));
        final int[] res = { 0, 0 };
        for (int level = 0; !q.isEmpty(); level++) {
            for (int size = q.size(); size > 0; size--) {
                final Integer curr = q.removeFirst();
                if (seen[curr]) {
                    continue;
                }
                seen[curr] = true;
                if (level > res[0]) {
                    res[0] = level;
                    res[1] = curr;
                }
                for (int next : g.getOrDefault(curr, Collections.emptyList())) {
                    q.offerLast(next);
                }
            }
        }
        return res;
    }

    static final class Util {
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

        private Util() {}
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
