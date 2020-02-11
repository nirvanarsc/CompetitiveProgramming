package weekly_155;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class P_1202 {

    static class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int count;

        UnionFind(int n) {
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
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        final int n = s.length();
        final UnionFind uf = new UnionFind(n);
        final Map<Integer, TreeMap<Character, Integer>> map = new HashMap<>();
        final char[] res = new char[n];
        for (List<Integer> l : pairs) {
            uf.union(l.get(0), l.get(1));
        }
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(uf.find(i), new TreeMap<>());
            map.get(uf.find(i)).merge(s.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < n; i++) {
            final Map.Entry<Character, Integer> first = map.get(uf.find(i)).firstEntry();
            if (first.getValue() == 1) {
                map.get(uf.find(i)).remove(first.getKey());
            } else {
                map.get(uf.find(i)).put(first.getKey(), first.getValue() - 1);
            }
            res[i] = first.getKey();
        }
        return new String(res);
    }
}
