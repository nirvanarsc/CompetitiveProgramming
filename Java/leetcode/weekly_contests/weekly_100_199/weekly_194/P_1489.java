package leetcode.weekly_contests.weekly_100_199.weekly_194;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.DataStructures.UnionFind;

public class P_1489 {

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new int[] { edges[i][0], edges[i][1], edges[i][2], i };
        }
        Arrays.sort(edges, Comparator.comparingInt(x -> x[2]));
        int mst = 0;
        for (int[] e : edges) {
            if (uf.find(e[0]) != uf.find(e[1])) {
                uf.union(e[0], e[1]);
                mst += e[2];
            }
        }
        final Set<Integer> critical = new HashSet<>();
        final List<Integer> pseudoCritical = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            int currMst = 0;
            uf = new UnionFind(n);
            for (int j = 0; j < edges.length; j++) {
                if (i != j) {
                    final int[] e = edges[j];
                    if (uf.find(e[0]) != uf.find(e[1])) {
                        uf.union(e[0], e[1]);
                        currMst += e[2];
                    }
                }
            }
            if (currMst > mst || uf.count() != 1) {
                critical.add(edges[i][3]);
            }
        }
        for (int[] edge : edges) {
            uf = new UnionFind(n);
            uf.union(edge[0], edge[1]);
            int currMst = edge[2];
            for (int[] e : edges) {
                if (uf.find(e[0]) != uf.find(e[1])) {
                    uf.union(e[0], e[1]);
                    currMst += e[2];
                }
            }
            if (currMst == mst && !critical.contains(edge[3])) {
                pseudoCritical.add(edge[3]);
            }
        }
        return Arrays.asList(new ArrayList<>(critical), pseudoCritical);
    }
}
