package codeforces.educational.edu_128;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public final class E {

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            int n = fs.nextInt();
            String l = fs.next();
            String r = fs.next();
            int ll = 0;
            int rr = n - 1;
            while (ll < n && l.charAt(ll) == '.' && r.charAt(ll) == '.') {
                ll++;
            }
            while (rr >= 0 && l.charAt(rr) == '.' && r.charAt(rr) == '.') {
                rr--;
            }
            l = l.substring(ll, rr + 1);
            r = r.substring(ll, rr + 1);
            n = rr - ll + 1;
            final char[][] g = new char[2][n];
            g[0] = l.toCharArray();
            g[1] = r.toCharArray();
            final int[][] dp = new int[n + 1][3];
            for (int[] row : dp) {
                Arrays.fill(row, (int) 1e9);
            }
            dp[0][0] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    if (dp[i][j] == (int) 1e9) {
                        continue;
                    }
                    if (g[0][i] == '.' && g[1][i] == '.') {
                        if (j == 0) {
                            dp[i + 1][0] = dp[i][0];
                        } else {
                            dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                        }
                    } else if (g[0][i] == '*' && g[1][i] == '.') {
                        if (j == 0) {
                            dp[i + 1][1] = dp[i][0];
                        } else if (j == 1) {
                            dp[i + 1][1] = Math.min(dp[i + 1][1], dp[i][1] + 1);
                        } else {
                            dp[i + 1][1] = Math.min(dp[i + 1][1], dp[i][2] + 2);
                            dp[i + 1][2] = Math.min(dp[i + 1][2], dp[i][2] + 2);
                        }
                    } else if (g[0][i] == '.' && g[1][i] == '*') {
                        if (j == 0) {
                            dp[i + 1][2] = dp[i][0];
                        } else if (j == 1) {
                            dp[i + 1][2] = Math.min(dp[i + 1][2], dp[i][1] + 2);
                            dp[i + 1][1] = Math.min(dp[i + 1][1], dp[i][1] + 2);
                        } else {
                            dp[i + 1][2] = Math.min(dp[i + 1][2], dp[i][2] + 1);
                        }
                    } else {
                        if (j == 0) {
                            dp[i + 1][1] = 1 + dp[i][0];
                            dp[i + 1][2] = 1 + dp[i][0];
                        } else if (j == 1) {
                            dp[i + 1][1] = Math.min(dp[i + 1][1], dp[i][1] + 2);
                            dp[i + 1][2] = Math.min(dp[i + 1][2], dp[i][1] + 2);
                        } else {
                            dp[i + 1][1] = Math.min(dp[i + 1][1], dp[i][2] + 2);
                            dp[i + 1][2] = Math.min(dp[i + 1][2], dp[i][2] + 2);
                        }
                    }
                }
            }
            System.out.println(Math.min(dp[n][1], dp[n][2]));
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

        public int nextSign() throws IOException {
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
