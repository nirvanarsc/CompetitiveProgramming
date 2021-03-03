package codeforces.educational.educational_105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public final class C {

//    public static void main(String[] args) {
//        final FastScanner fs = new FastScanner();
//        final int t = fs.nextInt();
//        for (int test = 0; test < t; test++) {
//            final int n = fs.nextInt();
//            final int m = fs.nextInt();
//            int[] a = fs.nextIntArray(n);
//            int[] b = fs.nextIntArray(m);
//            TreeMap<Integer, Integer> prePos = new TreeMap<>();
//            TreeMap<Integer, Integer> preNeg = new TreeMap<>();
//            TreeMap<Integer, Integer> prePosSpecial = new TreeMap<>();
//            TreeMap<Integer, Integer> preNegSpecial = new TreeMap<>();
//            prePos.put(0, 0);
//            preNeg.put(0, 0);
//            prePosSpecial.put(0, 0);
//            preNegSpecial.put(0, 0);
//            Set<Integer> special = new HashSet<>();
//            for (int i = 0; i < m; i++) {
//                special.add(b[i]);
//            }
//
//            int firstPos = -1;
//            for (int i = 0; i < n; i++) {
//                if (a[i] > 0) {
//                    firstPos = i;
//                    break;
//                }
//            }
//            int count = 0;
//            int spec = 0;
//            for (int i = firstPos; i < n; i++) {
//                if (special.contains(a[i])) {
//                    spec++;
//                }
//                prePos.put(a[i], ++count);
//                prePosSpecial.put(a[i], spec);
//            }
//            count = 0;
//            spec = 0;
//            for (int i = firstPos - 1; i >= 0; i--) {
//                if (special.contains(a[i])) {
//                    spec++;
//                }
//                preNeg.put(a[i], ++count);
//                preNegSpecial.put(a[i], spec);
//            }
//
//            int bestPos = prePosSpecial.lastEntry().getValue();
//
//            for (int i = firstPos; i < n; i++) {
//                int curr = prePos.floo()
//
//            }
//        }
//    }

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
