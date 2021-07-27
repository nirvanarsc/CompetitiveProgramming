package codeforces.global.global_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

@SuppressWarnings("ComparatorCombinators")
public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        final StringBuilder sb = new StringBuilder();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int m = fs.nextInt();
            final int x = fs.nextInt();
            final int[] arr = fs.nextIntArray(n);
            final int[] towers = new int[m];
            final PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
            final PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
            for (int i = 0; i < n; i++) {
                pq1.offer(new int[] { arr[i], i });
            }
            for (int i = 0; i < m; i++) {
                pq2.offer(new int[] { 0, i });
            }
            final int[] res = new int[n];
            while (!pq1.isEmpty()) {
                final int[] block = pq1.remove();
                final int[] tower = pq2.remove();
                towers[tower[1]] += block[0];
                res[block[1]] = tower[1];
                pq2.offer(new int[] { towers[tower[1]], tower[1] });
            }
            Utils.shuffleSort(towers);
            if (towers[m - 1] - towers[0] > x) {
                sb.append("NO\n");
                continue;
            }
            sb.append("YES\n");
            for (int i = 0; i < n; i++) {
                sb.append(res[i] + 1);
                sb.append(' ');
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append('\n');
        }
        System.out.println(sb);
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
