package leetcode.medium;

import java.util.TreeSet;

public class P_1061 {

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
                size[rootQ] = 0;
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
                size[rootP] = 0;
            }
            count--;
        }

        public int count() { return count; }

        public int[] size() { return size; }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        final char[] l = s1.toCharArray();
        final char[] r = s2.toCharArray();
        final int n = s1.length();
        @SuppressWarnings("unchecked")
        final TreeSet<Character>[] ts = new TreeSet[26];
        final UnionFind uf = new UnionFind(26);
        for (int i = 0; i < 26; i++) {
            ts[i] = new TreeSet<>();
        }
        for (int i = 0; i < n; i++) {
            uf.union(l[i] - 'a', r[i] - 'a');
            final int root = uf.find(l[i] - 'a');
            ts[root].add(l[i]);
            ts[root].add(r[i]);
        }
        final StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            final int root = uf.find(c - 'a');
            sb.append(ts[root].isEmpty() ? c : ts[root].first());
        }
        return sb.toString();
    }
}
