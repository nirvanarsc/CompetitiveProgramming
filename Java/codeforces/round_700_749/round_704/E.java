package codeforces.round_700_749.round_704;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class E {

    static int[] b = new int[(int) (2e5 + 5)];

    private static String yes(int m, int[] row) {
        final StringBuilder res = new StringBuilder();
        res.append("Yes\n");
        for (int i = 0; i < m; i++) {
            if (row[i] == 0) {
                row[i] = 1;
            }
            res.append(row[i]);
            res.append(' ');
        }
        res.append('\n');
        return res.toString();
    }

    private static void check(int p, int[][] a, int n, int m) {
        if (p == n) {
            System.out.println(yes(m, b));
            System.exit(0);
        }
        final List<Integer> fr = new ArrayList<>();
        int mistakes = 0;
        for (int i = 0; i < m; i++) {
            if (b[i] == 0) {
                fr.add(i);
            } else if (b[i] != a[p][i]) {
                mistakes++;
            }
        }
        if (mistakes > 2) {
            return;
        }
        final int k = fr.size();
        if (mistakes + k <= 2) {
            check(p + 1, a, n, m);
            return;
        }
        for (int mask = 0; mask < (1 << k); mask++) {
            int ppc = mistakes;
            for (int i = 0; i < k; i++) {
                if ((mask & (1 << i)) != 0) {
                    ppc++;
                } else {
                    b[fr.get(i)] = a[p][fr.get(i)];
                }
            }
            if (ppc == 2) {
                check(p + 1, a, n, m);
            }
            for (int i = 0; i < k; i++) {
                b[fr.get(i)] = 0;
            }
        }
    }

    private static void trySolve(int p, int q, int[][] a, int n, int m) {
        final List<Integer> bad = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (a[p][i] != a[q][i]) {
                bad.add(i);
            }
        }
        final int k = bad.size();
        for (int id : new int[] { p, q }) {
            for (int mask = 0; mask < (1 << k); mask++) {
                if (Integer.bitCount(mask) != 2) {
                    continue;
                }
                final List<Integer> mist = new ArrayList<>();
                for (int i = 0; i < k; i++) {
                    if ((mask & (1 << i)) != 0) {
                        mist.add(bad.get(i));
                    }
                }
                for (int i = 0; i < m; i++) {
                    if (i == mist.get(0) || i == mist.get(1)) {
                        b[i] = 0;
                    } else {
                        b[i] = a[id][i];
                    }
                }
                check(0, a, n, m);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final int n = fs.nextInt();
        final int m = fs.nextInt();
        final int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = fs.nextInt();
            }
        }
        for (int i = 1; i < n; i++) {
            int diff = 0;
            for (int j = 0; j < m; j++) {
                diff += a[0][j] != a[i][j] ? 1 : 0;
            }
            if (diff > 4) {
                System.out.println("No");
                return;
            }
            if (diff <= 2) {
                continue;
            }
            trySolve(0, i, a, n, m);
            System.out.println("No");
            return;
        }
        System.out.println(yes(m, a[0]));
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
