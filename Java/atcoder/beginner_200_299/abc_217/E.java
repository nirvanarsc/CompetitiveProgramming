package atcoder.beginner_200_299.abc_217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final StringBuilder sb = new StringBuilder();
        final Deque<Integer> dq = new ArrayDeque<>();
        final TreeMap<Integer, Integer> tm1 = new TreeMap<>();
        final TreeMap<Integer, Integer> tm2 = new TreeMap<>();
        final int q = fs.nextInt();
        int sorted = 0;
        int tm1Size = 0;
        int tm2Size = 0;
        for (int i = 0; i < q; i++) {
            final int t = fs.nextInt();
            if (t == 1) {
                final int x = fs.nextInt();
                dq.offerLast(x);
                if (sorted == 0) {
                    tm1.merge(x, 1, Integer::sum);
                    tm1Size++;
                } else {
                    tm2.merge(x, 1, Integer::sum);
                    tm2Size++;
                }
            } else if (t == 2) {
                if (sorted == 0) {
                    final int pop = dq.removeFirst();
                    sb.append(pop).append('\n');
                    if (tm1.containsKey(pop)) {
                        dec(tm1, pop);
                        tm1Size--;
                    } else {
                        dec(tm2, pop);
                        tm2Size--;
                    }
                } else {
                    final int pop = tm1.firstKey();
                    sb.append(pop).append('\n');
                    dec(tm1, pop);
                    sorted--;
                    tm1Size--;
                }
            } else {
                dq.clear();
                tm1Size += tm2Size;
                sorted = tm1Size;
                while (!tm2.isEmpty()) {
                    final Map.Entry<Integer, Integer> curr = tm2.pollFirstEntry();
                    tm1.merge(curr.getKey(), curr.getValue(), Integer::sum);
                }
                tm2Size = 0;
            }
        }
        System.out.println(sb);
    }

    private static void dec(TreeMap<Integer, Integer> map, int pop) {
        final int dec = map.merge(pop, -1, Integer::sum);
        if (dec == 0) {
            map.remove(pop);
        }
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
