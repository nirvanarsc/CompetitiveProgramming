package gcj.year_2021.round2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 1; test <= t; test++) {
            final int n = fs.nextInt();
            final int[] arr = fs.nextIntArray(n);
            List<Set<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                edges.add(new HashSet<>());
            }
            boolean ok = true;
            List<Integer> curr = new ArrayList<>();
            curr.add(0);
            for (int i = 1; i < n; i++) {
                if (Math.abs(arr[i] - arr[i - 1]) > 1) {
                    ok = false;
                    break;
                }
                if (arr[i] == 1) {
                    edges.get(i).add(curr.get(0));
                    curr.add(0, i);
                } else if(arr[i] - 1 == curr.size()) {
                    int idx = arr[i] - 1;
                    edges.get(curr.get(idx)).add(i);
                    curr.add(idx, i);
                } else {
                    int idx = arr[i] - 1;
                    int u = curr.get(idx);
                    int v = curr.get(idx + 1);
                    edges.get(u).remove(v);
                    edges.get(u).add(i);
                    curr.add(idx, i);
                }
            }

            System.out.println("Case #" + test + ": " + n);
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
