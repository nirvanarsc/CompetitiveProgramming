package leetcode.biweekly_contests.biweekly_73;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P_3 {

    static int n;
    static int[][] edges;
    static int[][] g;
    static List<Set<Integer>> res;

    @SuppressWarnings("AccessStaticViaInstance")
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        this.n = n;
        this.edges = edges;
        final int[] inDegree = new int[n];
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }
        g = packG();
        final Deque<Integer> dq = new ArrayDeque<>();
        res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new HashSet<>());
            if (inDegree[i] == 0) {
                dq.offerLast(i);
            }
        }
        final int[] topSort = new int[n];
        int idx = 0;
        while (!dq.isEmpty()) {
            final int u = dq.removeFirst();
            topSort[idx++] = u;
            for (int v : g[u]) {
                if (--inDegree[v] == 0) {
                    dq.offerLast(v);
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            final int u = topSort[i];
            for (int v : g[u]) {
                res.get(v).add(u);
            }
        }
        for (int i = 0; i < n; i++) {
            final Set<Integer> add = new HashSet<>();
            for (int par : res.get(topSort[i])) {
                add.addAll(res.get(par));
            }
            res.get(topSort[i]).addAll(add);
        }
        return res.stream()
                  .map(set -> set.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()))
                  .collect(Collectors.toList());
    }

    private static int[][] packG() {
        final int[][] g = new int[n][];
        final int[] size = new int[n];
        for (int[] edge : edges) {
            ++size[edge[0]];
        }
        for (int i = 0; i < n; i++) {
            g[i] = new int[size[i]];
        }
        for (int[] edge : edges) {
            g[edge[0]][--size[edge[0]]] = edge[1];
        }
        return g;
    }
}
