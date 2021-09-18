package atcoder.beginner_200_299.abc_218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final Map<Integer, List<Integer>> byX = new HashMap<>();
        final Map<Integer, List<Integer>> byY = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            final int x = fs.nextInt();
            final int y = fs.nextInt();
            byX.computeIfAbsent(x, val -> new ArrayList<>()).add(y);
            byY.computeIfAbsent(y, val -> new ArrayList<>()).add(x);
        }
        int res = 0;
        for (Entry<Integer, List<Integer>> e : byY.entrySet()) {
            final int key = e.getKey();
            final List<Integer> v = e.getValue();
            for (int i = 0; i < v.size(); i++) {
                for (int j = i + 1; j < v.size(); j++) {
                    int common = 0;
                    final Set<Integer> set = new HashSet<>();
                    for (int other : byX.get(v.get(i))) {
                        if (other > key) {
                            set.add(other);
                        }
                    }
                    for (int other : byX.get(v.get(j))) {
                        if (set.contains(other)) {
                            common++;
                        }
                    }
                    res += common;
                }
            }
        }
        System.out.println(res);
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
