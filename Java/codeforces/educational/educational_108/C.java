package codeforces.educational.educational_108;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public final class C {

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int t = fs.nextInt();
        final StringBuilder sb = new StringBuilder();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int[] u = new int[n];
            final int[] s = new int[n];
            final int[] f = new int[n];
            final int[] fM = new int[n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                u[i] = fs.nextInt() - 1;
                f[u[i]]++;
                fM[i] = -1;
            }
            for (int i = 0; i < n; i++) {
                s[i] = fs.nextInt();
                if (fM[u[i]] != -1) {
                    continue;
                }
                fM[u[i]] = count++;
            }
            final int[][] g = new int[count][];
            for (int i = 0; i < n; i++) {
                if (fM[u[i]] != -1) {
                    g[fM[u[i]]] = new int[f[u[i]]];
                }
            }
            final int[] sameSize = new int[n + 1];
            final int[] idx = new int[n + 1];
            for (int i = 0; i < n; i++) {
                if (f[i] > 0) {
                    sameSize[f[i]]++;
                }
            }
            for (int i = 0; i < n; i++) {
                g[fM[u[i]]][--f[u[i]]] = s[i];
            }
            for (int i = 0; i < count; i++) {
                Utils.shuffleSort(g[i]);
                g[i] = reverse(g[i], g[i].length);
            }
            int uniq = 0;
            for (int i = 0; i <= n; i++) {
                if (sameSize[i] > 0) {
                    idx[i] = uniq++;
                }
            }
            final long[][] g2 = new long[uniq][];
            for (int i = 0; i < count; i++) {
                final int gIdx = idx[g[i].length];
                if (g2[gIdx] == null) {
                    g2[gIdx] = new long[g[i].length];
                }
                for (int j = 0; j < g[i].length; j++) {
                    g2[gIdx][j] += g[i][j];
                }
            }
            final long[][] pre = new long[uniq][];
            for (int i = 0; i < uniq; i++) {
                final int L = g2[i].length;
                final long[] row = new long[L + 1];
                for (int j = 1; j <= L; j++) {
                    row[j] = row[j - 1] + g2[i][j - 1];
                }
                pre[i] = row;
            }
            final long[] res = new long[n];
            for (int i = 0; i < n; i++) {
                final int L = i + 1;
                long sum = 0;
                boolean all = true;
                for (int j = 0; j < uniq; j++) {
                    if (L > g2[j].length) {
                        continue;
                    }
                    all = false;
                    sum += pre[j][g2[j].length - (g2[j].length % L)];
                }
                res[i] = sum;
                if (all) {
                    break;
                }
            }
            for (int i = 0; i < n; i++) {
                sb.append(res[i]);
                sb.append(' ');
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int[] reverse(int[] nums, int n) {
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[n - 1 - i] = nums[i];
        }
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
