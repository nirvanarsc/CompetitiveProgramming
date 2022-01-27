package atcoder.beginner_200_299.abc_222;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class E {

    private static final int MOD = 998244353;

    static List<List<int[]>> g;
    static int[] count;
    static boolean[][] seen;
    static int[][] dp;
    static boolean ok;

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int k = fs.nextInt();
        final int[] arr = fs.nextIntArray(m);
        g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < (n - 1); i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            g.get(u).add(new int[] { v, i });
            g.get(v).add(new int[] { u, i });
        }
        count = new int[n - 1];
        for (int i = 1; i < m; i++) {
            ok = false;
            dfs(arr[i - 1] - 1, -1, arr[i] - 1);
        }
        int t = 0;
        for (int i = 0; i < (n - 1); i++) {
            t += count[i];
        }
        if ((t - k) % 2 != 0 || t < k) {
            System.out.println(0);
            return;
        }
        final int tar = (t - k) / 2;
        int zeroes = 0;
        final List<Integer> f = new ArrayList<>();
        for (int num : count) {
            if (num > 0) {
                f.add(num);
            } else {
                zeroes++;
            }
        }
        seen = new boolean[f.size()][tar + 1];
        dp = new int[f.size()][tar + 1];
        final int curr = dfs2(0, f, tar);
        long p = 1;
        for (int i = 0; i < zeroes; i++) {
            p = (p * 2L) % MOD;
        }
        System.out.println((p * curr) % MOD);
    }

    private static int dfs2(int idx, List<Integer> list, int tar) {
        if (idx == list.size()) {
            return tar == 0 ? 1 : 0;
        }
        if (seen[idx][tar]) {
            return dp[idx][tar];
        }
        int res = 0;
        if (list.get(idx) <= tar) {
            res = (res + dfs2(idx + 1, list, tar - list.get(idx))) % MOD;
        }
        res = (res + dfs2(idx + 1, list, tar)) % MOD;
        seen[idx][tar] = true;
        return dp[idx][tar] = res;
    }

    private static void dfs(int u, int p, int t) {
        if (u == t) {
            ok = true;
            return;
        }
        for (int[] v : g.get(u)) {
            if (v[0] != p) {
                count[v[1]]++;
                dfs(v[0], u, t);
                if (ok) {
                    break;
                }
                count[v[1]]--;
            }
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
