package atcoder.beginner_200_299.abc_207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;

public final class D {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final List<int[]> s = new ArrayList<>(n);
        final List<int[]> p = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            s.add(new int[] { fs.nextInt(), fs.nextInt() });
        }
        for (int i = 0; i < n; i++) {
            p.add(new int[] { fs.nextInt(), fs.nextInt() });
        }
        if (norm(p).equals(norm(s))) {
            System.out.println("Yes");
        } else if (norm2(p).equals(norm2(s))) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static final int[][] DIHEDRAL_DIRS = { { 1, -1 }, { 1, 1 } };

    private static final int[][] DIH_2 = { { -1, -1 }, { -1, 1 } };

    private static String norm(List<int[]> cells) {
        final TreeSet<String> normShapes = new TreeSet<>();
        for (int[] dir : DIHEDRAL_DIRS) {
            final List<int[]> s1 = new ArrayList<>();
            final List<int[]> s2 = new ArrayList<>();
            for (int[] cell : cells) {
                final int x = cell[0];
                final int y = cell[1];
                s1.add(new int[] { dir[0] * x, dir[1] * y });
                s2.add(new int[] { dir[0] * y, dir[1] * x });
            }
            for (List<int[]> s : Arrays.asList(s1, s2)) {
                // Sort is not important, just used to always pick the same value when hashing the path
                s.sort((o1, o2) -> o1[0] != o2[0] ? Integer.compare(o1[0], o2[0])
                                                  : Integer.compare(o1[1], o2[1]));
                final int x = s.get(0)[0];
                final int y = s.get(0)[1];
                final StringBuilder b = new StringBuilder();
                for (int[] p : s) {
                    b.append(p[0] - x).append(':').append(p[1] - y).append(':');
                }
                normShapes.add(b.toString());
            }
        }
        return normShapes.first();
    }

    private static String norm2(List<int[]> cells) {
        final TreeSet<String> normShapes = new TreeSet<>();
        for (int[] dir : DIH_2) {
            final List<int[]> s1 = new ArrayList<>();
            final List<int[]> s2 = new ArrayList<>();
            for (int[] cell : cells) {
                final int x = cell[0];
                final int y = cell[1];
                s1.add(new int[] { dir[0] * x, dir[1] * y });
                s2.add(new int[] { dir[0] * y, dir[1] * x });
            }
            for (List<int[]> s : Arrays.asList(s1, s2)) {
                // Sort is not important, just used to always pick the same value when hashing the path
                s.sort((o1, o2) -> o1[0] != o2[0] ? Integer.compare(o1[0], o2[0])
                                                  : Integer.compare(o1[1], o2[1]));
                final int x = s.get(0)[0];
                final int y = s.get(0)[1];
                final StringBuilder b = new StringBuilder();
                for (int[] p : s) {
                    b.append(p[0] - x).append(':').append(p[1] - y).append(':');
                }
                normShapes.add(b.toString());
            }
        }
        return normShapes.first();
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
