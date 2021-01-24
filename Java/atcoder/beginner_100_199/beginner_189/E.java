package atcoder.beginner_100_199.beginner_189;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int n = fs.nextInt();
        final int[][] p = new int[n][2];
        for (int i = 0; i < n; i++) {
            p[i] = new int[] { fs.nextInt(), fs.nextInt() };
        }
        final int m = fs.nextInt();
        final int[][] op = new int[m][2];
        for (int i = 0; i < m; i++) {
            final int type = fs.nextInt();
            if (type == 3 || type == 4) {
                op[i] = new int[] { type, fs.nextInt() };
            } else {
                op[i] = new int[] { type, -1 };
            }
        }
        final int q = fs.nextInt();
        final int[][] qq = new int[q][3];
        for (int i = 0; i < q; i++) {
            qq[i] = new int[] { fs.nextInt(), fs.nextInt() - 1, i };
        }
        final long[][] res = new long[q][2];
        Arrays.sort(qq, Comparator.comparingInt(a -> a[0]));
        int currOp = 0;
        long[][] mat = new long[3][3];
        mat[0][0] = mat[1][1] = mat[2][2] = 1;
        for (int i = 0; i < q; i++) {
            final int[] currQ = qq[i];
            while (currOp < currQ[0]) {
                final int type = op[currOp][0];
                final long[][] next = new long[3][3];
                if (type == 1) {
                    next[0][1] = 1;
                    next[1][0] = -1;
                } else if (type == 2) {
                    next[0][1] = -1;
                    next[1][0] = 1;
                } else if (type == 3) {
                    next[0][0] = -1;
                    next[1][1] = 1;
                    next[0][2] = 2 * op[currOp][1];
                } else {
                    next[0][0] = 1;
                    next[1][1] = -1;
                    next[1][2] = 2 * op[currOp][1];
                }
                next[2][2] = 1;
                currOp++;
                mat = mul(next, mat);
            }
            long[][] elem = new long[3][1];
            elem[0][0] = p[currQ[1]][0];
            elem[1][0] = p[currQ[1]][1];
            elem[2][0] = 1;
            elem = mul(mat, elem);
            res[currQ[2]] = new long[] { elem[0][0], elem[1][0] };
        }
        final PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < q; i++) {
            pw.println(res[i][0] + " " + res[i][1]);
        }
        pw.close();
    }

    private static long[][] mul(long[][] left, long[][] right) {
        final int lRow = left.length;
        final int lCol = left[0].length;
        final int rCol = right[0].length;
        final long[][] res = new long[lRow][rCol];
        for (int i = 0; i < lRow; i++) {
            for (int k = 0; k < lCol; k++) {
                for (int j = 0; j < rCol; j++) {
                    res[i][j] += left[i][k] * right[k][j];
                }
            }
        }
        return res;
    }

    static final class Utils {
        public static void shuffleSort(int[] arr) {
            shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffleSort(long[] arr) {
            shuffle(arr);
            Arrays.sort(arr);
        }

        public static void shuffle(int[] arr) {
            final Random r = new Random();

            for (int i = 0; i <= arr.length - 2; i++) {
                final int j = i + r.nextInt(arr.length - i);
                swap(arr, i, j);
            }
        }

        public static void shuffle(long[] arr) {
            final Random r = new Random();

            for (int i = 0; i <= arr.length - 2; i++) {
                final int j = i + r.nextInt(arr.length - i);
                swap(arr, i, j);
            }
        }

        public static void swap(int[] arr, int i, int j) {
            final int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

        public static void swap(long[] arr, int i, int j) {
            final long t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
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
