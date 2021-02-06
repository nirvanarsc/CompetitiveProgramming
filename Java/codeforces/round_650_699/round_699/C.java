package codeforces.round_650_699.round_699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        outer:
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int m = fs.nextInt();
            final int[] a = fs.nextIntArray(n);
            final int[] b = fs.nextIntArray(n);
            final int[] c = fs.nextIntArray(m);
            final int[] same = new int[(int) 1e5 + 5];
            Arrays.fill(same, -1);
            final Map<Integer, Deque<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (a[i] == b[i]) {
                    same[a[i]] = i;
                } else {
                    map.computeIfAbsent(b[i], val -> new ArrayDeque<>()).addFirst(i);
                }
            }
            int lastMatch = -1;
            int lastIdx = -1;
            for (int i = m - 1; i >= 0; i--) {
                final Deque<Integer> curr = map.getOrDefault(c[i], new ArrayDeque<>());
                if (!curr.isEmpty()) {
                    lastMatch = i;
                    lastIdx = curr.getLast();
                    break;
                } else if (same[c[i]] != -1) {
                    lastMatch = i;
                    lastIdx = same[c[i]];
                    break;
                }
            }
            final int[] res = new int[m];
            for (int i = 0; i < m; i++) {
                final Deque<Integer> curr = map.getOrDefault(c[i], new ArrayDeque<>());
                if (curr.isEmpty()) {
                    if (same[c[i]] == -1 && lastMatch < i) {
                        System.out.println("NO");
                        continue outer;
                    } else {
                        if (same[c[i]] != -1) {
                            res[i] = same[c[i]] + 1;
                        } else if (lastIdx != -1) {
                            res[i] = lastIdx + 1;
                        } else {
                            System.out.println("NO");
                            continue outer;
                        }
                    }
                } else {
                    res[i] = curr.removeFirst() + 1;
                    same[c[i]] = res[i] - 1;
                    if (curr.isEmpty()) {
                        map.remove(c[i]);
                    }
                }
            }
            if (!map.isEmpty()) {
                System.out.println("NO");
                continue;
            }
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(res[i]);
                sb.append(' ');
            }
            System.out.println("YES");
            System.out.println(sb);
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
