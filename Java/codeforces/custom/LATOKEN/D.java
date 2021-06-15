package codeforces.custom.LATOKEN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final List<int[]> edges = new ArrayList<>();
        final Deque<Integer> ask = new ArrayDeque<>();
        while (edges.size() < (n - 1)) {
            if (ask.isEmpty()) {
                query(1);
                final int[] ans = fs.nextIntArray(n);
                int odd = 0;
                int even = 0;
                int root = -1;
                for (int i = 0; i < n; i++) {
                    if (ans[i] == 0) {
                        root = i;
                    }
                    if (ans[i] % 2 == 0) {
                        even++;
                    } else {
                        odd++;
                    }
                }
                if (odd >= even) {
                    for (int i = 0; i < n; i++) {
                        if (ans[i] % 2 == 0 && i != root) {
                            ask.addFirst(i);
                        }
                        if (ans[i] == 1) {
                            edges.add(new int[] { i + 1, root + 1 });
                        }
                    }
                } else {
                    for (int i = 0; i < n; i++) {
                        if (ans[i] % 2 != 0) {
                            ask.addFirst(i);
                        }
                    }
                }
            } else {
                final int root = ask.removeFirst();
                query(root + 1);
                final int[] ans = fs.nextIntArray(n);
                for (int i = 0; i < n; i++) {
                    if (ans[i] == 1) {
                        edges.add(new int[] { i + 1, root + 1 });
                    }
                }
            }
        }
        System.out.println("!");
        final StringBuilder sb = new StringBuilder();
        for (int[] e : edges) {
            sb.append(e[0]).append(' ').append(e[1]).append('\n');
        }
        System.out.println(sb);
    }

    private static void query(int u) {
        System.out.printf("? %d\n", u);
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
