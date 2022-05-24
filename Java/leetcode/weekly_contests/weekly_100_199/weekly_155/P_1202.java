package leetcode.weekly_contests.weekly_100_199.weekly_155;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class P_1202 {

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

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        final int n = s.length();
        final UnionFind uf = new UnionFind(n);
        final Map<Integer, TreeMap<Character, Integer>> map = new HashMap<>();
        final char[] res = new char[n];
        for (List<Integer> l : pairs) {
            uf.union(l.get(0), l.get(1));
        }
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(uf.find(i), val -> new TreeMap<>()).merge(s.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < n; i++) {
            final TreeMap<Character, Integer> curr = map.get(uf.find(i));
            final char key = curr.firstKey();
            final int dec = curr.merge(key, -1, Integer::sum);
            if (dec == 0) {
                curr.remove(key);
            }
            res[i] = key;
        }
        return new String(res);
    }
}
