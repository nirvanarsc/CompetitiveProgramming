package atcoder.beginner_200_299.abc_264;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public final class F {

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int[] r = fs.nextIntArray(n);
        final int[] c = fs.nextIntArray(m);
        final int[][] g = new int[n][m];
        for (int i = 0; i < n; i++) {
            final char[] w = fs.next().toCharArray();
            g[i] = new int[m];
            for (int j = 0; j < m; j++) {
                g[i][j] = w[j] - '0';
            }
        }
        final long[][][] dp = new long[n][m][8];
        for (long[][] u : dp) {
            for (long[] v : u) {
                Arrays.fill(v, (long) 9e18);
            }
        }
        if (g[0][0] == 0) {
            dp[0][0][0] = 0;
            dp[0][0][3] = c[0];
            dp[0][0][5] = r[0];
            dp[0][0][6] = c[0] + r[0];
        } else {
            dp[0][0][1] = 0;
            dp[0][0][2] = c[0];
            dp[0][0][4] = r[0];
            dp[0][0][7] = c[0] + r[0];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 8; k++) {
                    if (dp[i][j][k] == (long) 9e18) {
                        continue;
                    }
                    if (j < m - 1) {
                        final int u = k & 1;
                        if (g[i][j + 1] == u) {
                            if ((k & 4) == 4) {
                                dp[i][j + 1][u | 6] = Math.min(dp[i][j + 1][u | 6], dp[i][j][k] + c[j + 1]);
                            } else {
                                dp[i][j + 1][u] = Math.min(dp[i][j + 1][u], dp[i][j][k]);
                            }
                        } else {
                            if ((k & 4) == 4) {
                                dp[i][j + 1][u | 4] = Math.min(dp[i][j + 1][u | 4], dp[i][j][k]);
                            } else {
                                dp[i][j + 1][u | 2] = Math.min(dp[i][j + 1][u | 2], dp[i][j][k] + c[j + 1]);
                            }
                        }
                    }
                    if (i < n - 1) {
                        final int u = k & 1;
                        if (g[i + 1][j] == u) {
                            if ((k & 2) == 2) {
                                dp[i + 1][j][u | 6] = Math.min(dp[i + 1][j][u | 6], dp[i][j][k] + r[i + 1]);
                            } else {
                                dp[i + 1][j][u] = Math.min(dp[i + 1][j][u], dp[i][j][k]);
                            }
                        } else {
                            if ((k & 2) == 2) {
                                dp[i + 1][j][u | 2] = Math.min(dp[i + 1][j][u | 2], dp[i][j][k]);
                            } else {
                                dp[i + 1][j][u | 4] = Math.min(dp[i + 1][j][u | 4], dp[i][j][k] + r[i + 1]);
                            }
                        }
                    }
                }
            }
        }
        long res = (long) 9e18;
        for (int k = 0; k < 8; k++) {
            res = Math.min(res, dp[n - 1][m - 1][k]);
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

    static class FastReader {
        private static final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        FastReader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            final byte[] buf = new byte[1024]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int readSign() throws IOException {
            byte c = read();
            while ('+' != c && '-' != c) {
                c = read();
            }
            return '+' == c ? 0 : 1;
        }

        private static boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }

        private int skip() throws IOException {
            int b;
            //noinspection StatementWithEmptyBody
            while ((b = read()) != -1 && isSpaceChar(b)) {}
            return b;
        }

        public char nc() throws IOException {
            return (char) skip();
        }

        public String next() throws IOException {
            int b = skip();
            final StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) { // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = read();
            }
            return sb.toString();
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            final boolean neg = c == '-';
            if (neg) { c = read(); }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) { return -ret; }
            return ret;
        }

        public int[] nextIntArray(int n) throws IOException {
            final int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = nextInt();
            }
            return res;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') { c = read(); }
            final boolean neg = c == '-';
            if (neg) { c = read(); }
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg) { return -ret; }
            return ret;
        }

        public long[] nextLongArray(int n) throws IOException {
            final long[] res = new long[n];
            for (int i = 0; i < n; i++) {
                res[i] = nextLong();
            }
            return res;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') { c = read(); }
            final boolean neg = c == '-';
            if (neg) { c = read(); }

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg) { return -ret; }
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) { buffer[0] = -1; }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) { fillBuffer(); }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            din.close();
        }
    }
}
