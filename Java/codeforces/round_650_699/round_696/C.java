package codeforces.round_650_699.round_696;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final PrintWriter pw = new PrintWriter(System.out);
        final int t = fs.nextInt();
        outer:
        for (int test = 0; test < t; test++) {
            final int n = 2 * fs.nextInt();
            final int[] arr = fs.nextIntArray(n);
            Utils.shuffleSort(arr);
            final TreeMap<Integer, Integer> tm = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                tm.merge(arr[i], 1, Integer::sum);
            }
            for (int i = 0; i < n - 1; i++) {
                final TreeMap<Integer, Integer> bst = new TreeMap<>(tm);
                final Deque<int[]> q = new ArrayDeque<>();
                q.offerLast(new int[] { arr[n - 1], arr[i] });
                dec(arr[i], bst);
                dec(arr[n - 1], bst);
                int target = arr[n - 1];
                while (!bst.isEmpty()) {
                    final Integer max = bst.lastKey();
                    dec(max, bst);
                    if (!bst.containsKey(target - max)) {
                        break;
                    }
                    dec(target - max, bst);
                    q.offerLast(new int[] { max, target - max });
                    target = Math.max(max, target - max);
                }
                if (bst.isEmpty()) {
                    pw.println("YES");
                    pw.println(q.getFirst()[0] + q.getFirst()[1]);
                    while (!q.isEmpty()) {
                        final int[] curr = q.removeFirst();
                        pw.println(curr[0] + " " + curr[1]);
                    }
                    continue outer;
                }
            }
            pw.println("NO");
        }
        pw.close();
    }

    private static void dec(int key, TreeMap<Integer, Integer> bst) {
        final Integer res = bst.merge(key, -1, Integer::sum);
        if (res == 0) {
            bst.remove(key);
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
