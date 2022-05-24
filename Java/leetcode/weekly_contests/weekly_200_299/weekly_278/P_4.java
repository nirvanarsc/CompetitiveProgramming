package leetcode.weekly_contests.weekly_200_299.weekly_278;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_4 {

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

    public int[] groupStrings(String[] words) {
        final Map<Integer, Integer> f = new HashMap<>();
        for (String w : words) {
            int curr = 0;
            for (int j = 0; j < w.length(); j++) {
                curr |= 1 << w.charAt(j) - 'a';
            }
            f.merge(curr, 1, Integer::sum);
        }
        final List<Integer> uniq = new ArrayList<>(f.keySet());
        final int n = uniq.size();
        final UnionFind uf = new UnionFind(n);
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            final int mask = uniq.get(i);
            map.put(mask, i);
            uf.size()[i] = f.get(mask);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            final int key = entry.getKey();
            final int u = entry.getValue();
            for (int i = 0; i < 26; i++) {
                final int comp = key ^ (1 << i);
                Integer v = map.get(comp);
                if (v != null) {
                    uf.union(u, v);
                }
                if ((key & (1 << i)) != 0) {
                    for (int j = 0; j < 26; j++) {
                        if ((comp & (1 << j)) == 0) {
                            v = map.get(comp | (1 << j));
                            if (v != null) {
                                uf.union(u, v);
                            }
                        }
                    }
                }
            }
        }
        final int c = uf.count;
        int size = 0;
        for (int sz : uf.size()) {
            size = Math.max(size, sz);
        }
        return new int[] { c, size };
    }
}
