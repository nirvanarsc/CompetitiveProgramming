package codeforces.round_650_699.round_663;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    private static class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int count;

        public UnionFind(int n) {
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

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final String[] line = in.nextLine().split(" ");
            final int n = Integer.parseInt(line[0]);
            final int m = Integer.parseInt(line[1]);
            final char[][] arr = new char[n][m];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLine().toCharArray();
            }
            final UnionFind uf = new UnionFind(n * m);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    final int currIdx = getIndex(m, i, j);
                    if (arr[i][j] == 'R') {
                        if (j < m - 1) {
                            final int right = getIndex(m, i, j + 1);
                            uf.union(currIdx, right);
                        }
                    } else {
                        if (i < n - 1) {
                            final int bot = getIndex(m, i + 1, j);
                            uf.union(currIdx, bot);
                        }
                    }
                }
            }
            System.out.println(uf.count() - 1);
        }
    }

    private static int getIndex(int colSize, int r, int c) {
        return r * colSize + c;
    }
}
