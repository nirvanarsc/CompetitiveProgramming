package leetcode.weekly_contests.weekly_400_499.weekly_457;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class P_2 {

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

    public int[] processQueries(int n, int[][] connections, int[][] queries) {
        final UnionFind uf = new UnionFind(n);
        final boolean[] online = new boolean[n];
        Arrays.fill(online, true);
        for (int[] c : connections) {
            uf.union(c[0] - 1, c[1] - 1);
        }
        final TreeSet[] ts = new TreeSet[n];
        for (int i = 0; i < n; i++) {
            ts[uf.find(i)] = new TreeSet<Integer>();
        }
        for (int i = 0; i < n; i++) {
            ts[uf.find(i)].add(i);
        }
        final List<Integer> res = new ArrayList<>();
        for (int[] query : queries) {
            final int t = query[0];
            final int x = query[1] - 1;
            if (t == 1) {
                if (online[x]) {
                    res.add(x + 1);
                } else {
                    res.add(ts[uf.find(x)].isEmpty() ? -1 : (int) ts[uf.find(x)].first() + 1);
                }
            } else {
                online[x] = false;
                ts[uf.find(x)].remove(x);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
