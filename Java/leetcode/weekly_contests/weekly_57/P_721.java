package leetcode.weekly_contests.weekly_57;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class P_721 {

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

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        final List<Set<String>> ts = new ArrayList<>();
        final Map<String, Integer> map = new HashMap<>();
        final int n = accounts.size();
        for (int i = 0; i < n; i++) {
            ts.add(new TreeSet<>());
            for (int j = 1; j < accounts.get(i).size(); j++) {
                map.putIfAbsent(accounts.get(i).get(j), i);
            }
        }
        final UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            final int u = map.get(accounts.get(i).get(1));
            for (int j = 2; j < accounts.get(i).size(); j++) {
                uf.union(u, map.get(accounts.get(i).get(j)));
            }
        }
        for (int i = 0; i < n; i++) {
            final int u = map.get(accounts.get(i).get(1));
            final int p = uf.find(u);
            ts.get(p).addAll(accounts.get(i).subList(1, accounts.get(i).size()));
        }
        final List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ts.get(i).isEmpty()) {
                continue;
            }
            final List<String> curr = new ArrayList<>();
            curr.add(accounts.get(i).get(0));
            curr.addAll(ts.get(i));
            res.add(curr);
        }
        return res;
    }
}
