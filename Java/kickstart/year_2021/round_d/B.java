package kickstart.year_2021.round_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

public final class B {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int x = 1; x <= t; x++) {
            final int n = fs.nextInt();
            long c = fs.nextLong();
            final List<long[]> list = new ArrayList<>();
            final Map<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.merge(fs.nextLong(), 1, Integer::sum);
                map.merge(fs.nextLong() - 1, -1, Integer::sum);
            }
            for (Map.Entry<Long, Integer> e : map.entrySet()) {
                list.add(new long[] { e.getKey(), e.getValue() });
            }
            final PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
            list.sort(Comparator.comparingLong(a -> a[0]));
            long prev = list.get(0)[0];
            int open = 0;
            for (long[] curr : list) {
                if (open > 0) {
                    pq.offer(new long[] { open, curr[0] - prev });
                }
                open += curr[1];
                prev = curr[0];
            }
            long res = n;
            while (c > 0 && !pq.isEmpty()) {
                final long[] curr = pq.remove();
                final long take = Math.min(c, curr[1]);
                res += take * curr[0];
                c -= take;
            }
            System.out.println("Case #" + x + ": " + res);
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
