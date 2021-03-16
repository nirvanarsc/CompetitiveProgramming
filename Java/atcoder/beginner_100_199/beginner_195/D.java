package atcoder.beginner_100_199.beginner_195;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int q = fs.nextInt();
        final int[][] bags = new int[n][2];
        for (int i = 0; i < n; i++) {
            bags[i] = new int[] { fs.nextInt(), fs.nextInt() };
        }
        final int[] boxes = fs.nextIntArray(m);
        for (int i = 0; i < q; i++) {
            final int l = fs.nextInt() - 1;
            final int r = fs.nextInt() - 1;
            final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1]
                                                                          ? Integer.compare(a[0], b[0])
                                                                          : Integer.compare(b[1], a[1]));
            for (int j = 0; j < n; j++) {
                pq.offer(bags[j]);
            }
            final TreeMap<Integer, Integer> ts = new TreeMap<>();
            for (int j = 0; j < l; j++) {
                ts.merge(boxes[j], 1, Integer::sum);
            }
            for (int j = r + 1; j < m; j++) {
                ts.merge(boxes[j], 1, Integer::sum);
            }
            int res = 0;
            while (!pq.isEmpty()) {
                final int[] bag = pq.remove();
                final Integer ceil = ts.ceilingKey(bag[0]);
                if (ceil != null) {
                    final int dec = ts.merge(ceil, -1, Integer::sum);
                    if (dec == 0) {
                        ts.remove(ceil);
                    }
                    res += bag[1];
                }
            }
            System.out.println(res);
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
