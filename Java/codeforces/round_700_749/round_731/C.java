package codeforces.round_700_749.round_731;

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

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final StringBuilder sb = new StringBuilder();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            int k = fs.nextInt();
            final int n = fs.nextInt();
            final int m = fs.nextInt();
            final Deque<Integer> l = new ArrayDeque<>();
            final Deque<Integer> r = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                l.offerLast(fs.nextInt());
            }
            for (int i = 0; i < m; i++) {
                r.offerLast(fs.nextInt());
            }
            final List<Integer> res = new ArrayList<>();
            while (!l.isEmpty() || !r.isEmpty()) {
                while (!l.isEmpty() && l.getFirst() == 0) {
                    k++;
                    res.add(l.removeFirst());
                }
                while (!r.isEmpty() && r.getFirst() == 0) {
                    k++;
                    res.add(r.removeFirst());
                }
                if (l.isEmpty() && r.isEmpty()) {
                    break;
                } else if (l.isEmpty()) {
                    if (r.getFirst() <= k) {
                        res.add(r.removeFirst());
                    } else {
                        break;
                    }
                } else if (r.isEmpty()) {
                    if (l.getFirst() <= k) {
                        res.add(l.removeFirst());
                    } else {
                        break;
                    }
                } else if (l.getFirst() < r.getFirst()) {
                    if (l.getFirst() <= k) {
                        res.add(l.removeFirst());
                    } else {
                        break;
                    }
                } else {
                    if (r.getFirst() <= k) {
                        res.add(r.removeFirst());
                    } else {
                        break;
                    }
                }
            }
            if (res.size() != (n + m)) {
                sb.append(-1).append('\n');
            } else {
                for (int i = 0; i < res.size(); i++) {
                    sb.append(res.get(i)).append(' ');
                }
                sb.append('\n');
            }
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
