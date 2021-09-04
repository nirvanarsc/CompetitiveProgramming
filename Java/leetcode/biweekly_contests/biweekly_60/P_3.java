package leetcode.biweekly_contests.biweekly_60;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_3 {

    class LockingTree {

        int n;
        int[][] edges;
        int[][] g;
        int[] locked;
        int[] par;

        public LockingTree(int[] parent) {
            par = parent;
            n = parent.length;
            edges = new int[n - 1][2];
            for (int i = 1; i < n; i++) {
                edges[i - 1] = new int[] { i, parent[i] };
            }
            g = packG();
            locked = new int[n];
        }

        public boolean lock(int num, int user) {
            if (locked[num] == 0) {
                locked[num] = user;
                return true;
            }
            return false;
        }

        public boolean unlock(int num, int user) {
            if (locked[num] == user) {
                locked[num] = 0;
                return true;
            }
            return false;
        }

        public boolean upgrade(int num, int user) {
            int v = num;
            while (v != -1) {
                if (locked[v] != 0) {
                    return false;
                }
                v = par[v];
            }
            final int[] count = { 0 };
            dfs1(num, par[num], count);
            if (count[0] == 0) {
                return false;
            }
            dfs2(num, par[num]);
            locked[num] = user;
            return true;
        }

        private void dfs1(int u, int par, int[] count) {
            if (locked[u] != 0) {
                count[0]++;
            }
            for (int v : g[u]) {
                if (v != par) {
                    dfs1(v, u, count);
                }
            }
        }

        private void dfs2(int u, int par) {
            if (locked[u] != 0) {
                locked[u] = 0;
            }
            for (int v : g[u]) {
                if (v != par) {
                    dfs2(v, u);
                }
            }
        }

        private int[][] packG() {
            final int[][] g = new int[n][];
            final int[] size = new int[n];
            for (int[] edge : edges) {
                ++size[edge[0]];
                ++size[edge[1]];
            }
            for (int i = 0; i < n; i++) {
                g[i] = new int[size[i]];
            }
            for (int[] edge : edges) {
                g[edge[0]][--size[edge[0]]] = edge[1];
                g[edge[1]][--size[edge[1]]] = edge[0];
            }
            return g;
        }
    }
}
