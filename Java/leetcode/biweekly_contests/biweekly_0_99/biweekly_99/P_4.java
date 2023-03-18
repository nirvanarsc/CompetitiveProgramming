package leetcode.biweekly_contests.biweekly_0_99.biweekly_99;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_4 {

    static int n;
    static int[][] g;
    static int[][] edges;
    static List<Set<Integer>> guess;
    static int res;
    static int curr;
    static int limit;

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        n = edges.length + 1;
        //noinspection AccessStaticViaInstance
        this.edges = edges;
        g = packG();
        guess = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            guess.add(new HashSet<>());
        }
        for (int[] c : guesses) {
            guess.get(c[0]).add(c[1]);
        }
        res = 0;
        curr = 0;
        limit = k;
        dfs(0, -1);
        dfs2(0, -1);
        return res;
    }

    private static void dfs(int u, int p) {
        for (int v : g[u]) {
            if (v != p) {
                curr += guess.get(u).contains(v) ? 1 : 0;
                dfs(v, u);
            }
        }
    }

    private static void dfs2(int u, int p) {
        if (curr >= limit) {
            res++;
        }
        for (int v : g[u]) {
            if (v != p) {
                curr += guess.get(v).contains(u) ? 1 : 0;
                curr -= guess.get(u).contains(v) ? 1 : 0;
                dfs2(v, u);
                curr -= guess.get(v).contains(u) ? 1 : 0;
                curr += guess.get(u).contains(v) ? 1 : 0;
            }
        }
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
