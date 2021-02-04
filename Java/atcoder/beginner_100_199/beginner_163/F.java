package atcoder.beginner_100_199.beginner_163;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class F {

    private static final class BIT {
        private final int n;
        private final long[] data;

        private BIT(int n) {
            this.n = n;
            data = new long[n + 1];
        }

        public void add(int idx, long val) {
            for (int i = idx + 1; i <= n; i += lsb(i)) {
                data[i] += val;
            }
        }

        public long sum(int l, int r) {
            return sum(r - 1) - sum(l - 1);
        }

        private long sum(int idx) {
            long res = 0;
            for (int i = idx + 1; i > 0; i -= lsb(i)) {
                res += data[i];
            }
            return res;
        }

        private static int lsb(int i) {
            return i & -i;  // zeroes all the bits except the least significant one
        }
    }

    static int time;

    public static void main(String[] args) throws IOException {
        final FastReader fs = new FastReader();
        final PrintWriter pw = new PrintWriter(System.out);
        final int n = fs.nextInt();
        final List<List<Integer>> g = new ArrayList<>(n);
        final List<List<Integer>> colorList = new ArrayList<>(n);
        final int[] in = new int[n];
        final int[] out = new int[n];
        final int[] par = new int[n];
        final int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = fs.nextInt() - 1;
            g.add(new ArrayList<>());
            colorList.add(new ArrayList<>());
        }
        for (int i = 0; i < (n - 1); i++) {
            final int u = fs.nextInt() - 1;
            final int v = fs.nextInt() - 1;
            g.get(u).add(v);
            g.get(v).add(u);
        }
        dfs(0, -1, in, out, color, par, g, colorList);
        final BIT bit = new BIT(2 * n);
        for (int i = 0; i < n; i++) {
            bit.add(in[i], 1);
        }
        final long total = c2(n);
        for (int c = 0; c < n; c++) {
            final List<long[]> changes = new ArrayList<>();
            final List<Integer> curr = colorList.get(c);
            if (curr.isEmpty()) {
                pw.println(0);
                continue;
            }
            long res = total;
            for (int i = curr.size() - 1; i >= 0; i--) {
                final int node = curr.get(i);
                long count = 1;
                for (int adj : g.get(node)) {
                    if (adj != par[node]) {
                        // we exclude that parent node when counting paths
                        final long subSize = bit.sum(in[adj], out[adj]);
                        res -= c2(subSize);
                        count += subSize;
                    }
                }
                bit.add(in[node], -count);
                changes.add(new long[] { in[node], count });
            }
            res -= c2(bit.sum(0, 2 * n));
            for (long[] change : changes) {
                bit.add((int) change[0], change[1]);
            }
            pw.println(res);
        }
        pw.close();
    }

    private static long c2(long size) {
        return (size * (size + 1)) / 2;
    }

    private static void dfs(int u, int v, int[] in, int[] out, int[] color, int[] parent,
                            List<List<Integer>> g, List<List<Integer>> colorList) {
        parent[u] = v;
        colorList.get(color[u]).add(u);
        in[u] = time++;
        for (int next : g.get(u)) {
            if (next != v) {
                dfs(next, u, in, out, color, parent, g, colorList);
            }
        }
        out[u] = time++;
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
