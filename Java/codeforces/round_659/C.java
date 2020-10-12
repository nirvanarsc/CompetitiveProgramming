package codeforces.round_659;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

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

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        outer:
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final String s1 = in.nextLine();
            final String s2 = in.nextLine();
            final UnionFind uf = new UnionFind(20);
            int res = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) > s2.charAt(i)) {
                    System.out.println(-1);
                    continue outer;
                }
                if (uf.find(s1.charAt(i) - 'a') != uf.find(s2.charAt(i) - 'a')) {
                    uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
