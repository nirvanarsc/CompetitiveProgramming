package atcoder.beginner_200_299.abc_218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public final class C {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final char[][] s = new char[n][n];
        final char[][] t = new char[n][n];
        for (int i = 0; i < n; i++) {
            s[i] = fs.next().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            t[i] = fs.next().toCharArray();
        }
        final int[] sxy = { (int) 1e9, (int) 1e9, 0, 0 };
        final int[] txy = { (int) 1e9, (int) 1e9, 0, 0 };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s[i][j] == '#') {
                    sxy[0] = Math.min(sxy[0], i);
                    sxy[1] = Math.min(sxy[1], j);
                    sxy[2] = Math.max(sxy[2], i);
                    sxy[3] = Math.max(sxy[3], j);
                }
                if (t[i][j] == '#') {
                    txy[0] = Math.min(txy[0], i);
                    txy[1] = Math.min(txy[1], j);
                    txy[2] = Math.max(txy[2], i);
                    txy[3] = Math.max(txy[3], j);
                }
            }
        }
        final StringBuilder target = new StringBuilder();
        for (int i = txy[0]; i <= txy[2]; i++) {
            for (int j = txy[1]; j <= txy[3]; j++) {
                target.append(t[i][j]);
            }
            target.append(',');
        }
        final String tar = target.toString();
        for (String curr : f(s, sxy)) {
            if (tar.equals(curr)) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }

    private static List<String> f(char[][] g, int[] xy) {
        final List<String> res = new ArrayList<>();
        final StringBuilder target = new StringBuilder();
        for (int i = xy[0]; i <= xy[2]; i++) {
            for (int j = xy[1]; j <= xy[3]; j++) {
                target.append(g[i][j]);
            }
            target.append(',');
        }
        res.add(target.toString());
        target.setLength(0);
        for (int j = xy[1]; j <= xy[3]; j++) {
            for (int i = xy[2]; i >= xy[0]; i--) {
                target.append(g[i][j]);
            }
            target.append(',');
        }
        res.add(target.toString());
        target.setLength(0);
        for (int i = xy[2]; i >= xy[0]; i--) {
            for (int j = xy[3]; j >= xy[1]; j--) {
                target.append(g[i][j]);
            }
            target.append(',');
        }
        res.add(target.toString());
        target.setLength(0);
        for (int j = xy[3]; j >= xy[1]; j--) {
            for (int i = xy[0]; i <= xy[2]; i++) {
                target.append(g[i][j]);
            }
            target.append(',');
        }
        res.add(target.toString());
        return res;
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
