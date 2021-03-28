package gcj.year_2021.qualifying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        final int n = fs.nextInt();
        final int q = fs.nextInt();
        for (int i = 0; i < t; i++) {
            final List<Integer> list = new ArrayList<>(Arrays.asList(1, 2));
            for (int j = 2; j < n; j++) {
                add(list, j + 1, fs);
            }
            if (!printAns(list, fs)) {
                return;
            }
        }
    }

    private static void add(List<Integer> list, int toAdd, FastScanner fs) {
        final int targetIndex = getTargetIndex(list, toAdd, 0, list.size(), fs);
        list.add(targetIndex, toAdd);
    }

    @SuppressWarnings("TailRecursion")
    private static int getTargetIndex(List<Integer> list, int toAdd, int l, int r, FastScanner fs) {
        if (l == r) {
            return l;
        }
        if (l + 1 == r) {
            if (r != list.size()) {
                r++;
            } else {
                l--;
            }
        }
        final int leftmostpivot = l;
        final int rightmostpivot = r - 1;
        final int nSplits = rightmostpivot - leftmostpivot + 1;
        final int m1 = leftmostpivot + (nSplits - 1) / 3;
        final int m2 = rightmostpivot - (nSplits - 1) / 3;
        final int med = query(toAdd, list.get(m1), list.get(m2), fs);
        if (med == list.get(m1)) {
            return getTargetIndex(list, toAdd, l, m1, fs);
        } else if (med == list.get(m2)) {
            return getTargetIndex(list, toAdd, m2 + 1, r, fs);
        } else {
            return getTargetIndex(list, toAdd, m1 + 1, m2, fs);
        }
    }

    private static boolean printAns(List<Integer> res, FastScanner fs) {
        for (int i = 0; i < res.size(); i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(res.get(i));
        }
        System.out.println();
        System.out.flush();
        return fs.nextInt() == 1;
    }

    private static int query(int x, int y, int z, FastScanner fs) {
        System.out.println(x + " " + y + ' ' + z);
        System.out.flush();
        return fs.nextInt();
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
