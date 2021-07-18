package leetcode.weekly_contests.weekly_250;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_4 {

    static int n;
    static int[][] edges;
    static int[][] g;
    static int[] res;
    static Map<Integer, List<int[]>> qq;
    static Trie root;

    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        n = parents.length;
        edges = new int[n - 1][2];
        int start = -1;
        for (int i = 0, j = 0; i < parents.length; i++) {
            if (parents[i] != -1) {
                edges[j++] = new int[] { i, parents[i] };
            } else {
                start = i;
            }
        }
        g = packG();
        res = new int[queries.length];
        root = new Trie();
        qq = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            qq.computeIfAbsent(queries[i][0], val -> new ArrayList<>()).add(new int[] { queries[i][1], i });
        }
        dfs(start, -1);
        return res;
    }

    private static void dfs(int u, int p) {
        add(root, u);
        for (int[] q : qq.getOrDefault(u, Collections.emptyList())) {
            res[q[1]] = maxXor(root, q[0]);
        }
        for (int v : g[u]) {
            if (v != p) {
                dfs(v, u);
            }
        }
        remove(root, u);
    }

    private static class Trie {
        Trie[] children = new Trie[2];
        int size;
    }

    private static void add(Trie root, int num) {
        Trie curr = root;
        for (int i = 25; i >= 0; i--) {
            final int currBit = (num >> i) & 1;
            if (curr.children[currBit] == null) {
                curr.children[currBit] = new Trie();
            }
            curr = curr.children[currBit];
            curr.size++;
        }
    }

    private static void remove(Trie root, int num) {
        Trie curr = root;
        for (int i = 25; i >= 0; i--) {
            final int currBit = (num >> i) & 1;
            curr = curr.children[currBit];
            curr.size--;
        }
    }

    private static int maxXor(Trie root, int num) {
        Trie curr = root;
        int res = 0;
        for (int i = 25; i >= 0; i--) {
            int currBit = (num >> i) & 1;
            if (curr.children[currBit ^ 1] != null && curr.children[currBit ^ 1].size > 0) {
                res |= 1 << i;
                currBit ^= 1;
            }
            curr = curr.children[currBit];
        }
        return res;
    }

    private static int[][] packG() {
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
