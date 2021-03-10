package codeforces.round_700_749.round_706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public final class E {

    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final int t = fs.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = fs.nextInt();
            final int m = fs.nextInt();
            char[][] g = new char[n][m];
            for (int i = 0; i < n; i++) {
                g[i] = fs.next().toCharArray();
            }
            final UnionFind uf = new UnionFind(n * m);
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    if (g[row][col] == 'X') {
                        for (int[] dir : DIRS) {
                            final int nx = row + dir[0];
                            final int ny = col + dir[1];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && g[nx][ny] == 'X') {
                                uf.union(getIndex(m, row, col), getIndex(m, nx, ny));
                            }
                        }
                    }
                }
            }
            int cc = 0;
            Map<Integer, Integer> ccParent = new HashMap<>();
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    if (g[row][col] == 'X' && uf.find(getIndex(m, row, col)) == getIndex(m, row, col)) {
                        ccParent.put(uf.find(getIndex(m, row, col)), cc);
                        cc++;
                    }
                }
            }
            if (cc <= 1) {
                for (int i = 0; i < n; i++) {
                    System.out.println(g[i]);
                }
                continue;
            }
            UnionFind uf2 = new UnionFind(cc);
            while (uf2.count() != 1) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (uf2.count() == 1) {
                            break;
                        }
                        if (g[i][j] == '.') {
                            List<int[]> adj = new ArrayList<>();
                            for (int[] dir : DIRS) {
                                final int nx = i + dir[0];
                                final int ny = j + dir[1];
                                if (nx >= 0 && nx < n && ny >= 0 && ny < m && g[nx][ny] == 'X') {
                                    adj.add(new int[] { nx, ny });
                                }
                            }

                            if (adj.size() > 1) {

                                int[] f = adj.get(0);
                                int fId = ccParent.get(uf.find(getIndex(m, f[0], f[1])));
                                boolean ok = false;
                                for (int k = 1; k < adj.size(); k++) {
                                    int[] c = adj.get(k);
                                    int cId = ccParent.get(uf.find(getIndex(m, c[0], c[1])));
                                    if (cId != fId) {
                                        ok = true;
                                        break;
                                    }
                                }
                                if (ok) {

                                    g[i][j] = 'X';
                                    manualUnion(uf, uf.find(getIndex(m, f[0], f[1])),
                                                uf.find(getIndex(m, i, j)));
                                    for (int k = 1; k < adj.size(); k++) {
                                        int[] c = adj.get(k);
                                        int cId = ccParent.get(uf.find(getIndex(m, c[0], c[1])));
                                        manualUnion(uf, uf.find(getIndex(m, f[0], f[1])),
                                                    uf.find(getIndex(m, c[0], c[1])));
                                        uf2.union(fId, cId);
                                    }
                                    int newId = uf2.find(fId);
                                    for (int k = 0; k < adj.size(); k++) {
                                        int[] c = adj.get(k);
                                        ccParent.put(uf.find(getIndex(m, c[0], c[1])), newId);
                                    }
                                }
                            } else if(adj.size() == 1) {
                                int[] f = adj.get(0);
                                int fId = ccParent.get(uf.find(getIndex(m, f[0], f[1])));
                                g[i][j] = 'X';
                                manualUnion(uf, uf.find(getIndex(m, f[0], f[1])),
                                            uf.find(getIndex(m, i, j)));
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.println(g[i]);
            }
        }
    }

    private static void manualUnion(UnionFind uf, int rootP, int rootQ) {
        uf.parent[rootQ] = rootP;
        uf.size[rootP] += uf.size[rootQ];
        uf.size[rootQ] = 0;
    }

    private static final class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int count;

        private UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int p) {
            // path compression
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            final int rootP = find(p);
            final int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            // union by size
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public int count() { return count; }

        public int[] size() { return size; }
    }

    private static int getIndex(int colSize, int r, int c) {
        return r * colSize + c;
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
