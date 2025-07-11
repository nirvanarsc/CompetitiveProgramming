package leetcode.biweekly_contests.biweekly_100_199.biweekly_142;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_2 {

    public int[] findSubtreeSizes(int[] parent, String s) {
        final int n = parent.length;
        final int[] finalParent = new int[n];
        final int[] closestAncestor = new int[26];
        finalParent[0] = -1;
        Arrays.fill(closestAncestor, -1);
        List<List<Integer>> g = buildG(parent, n);
        dfs1(0, g, s.toCharArray(), finalParent, closestAncestor);

        g = buildG(finalParent, n);
        final int[] res = new int[n];
        dfs2(0, g, res);
        return res;
    }

    private static List<List<Integer>> buildG(int[] parent, int n) {
        final List<List<Integer>> originalAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            originalAdj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            originalAdj.get(parent[i]).add(i);
        }
        return originalAdj;
    }

    private static void dfs1(int u, List<List<Integer>> g, char[] w, int[] finalParent, int[] lca) {
        final int newP = lca[w[u] - 'a'];
        if (newP != -1) {
            finalParent[u] = newP;
        }
        final int origP = lca[w[u] - 'a'];
        lca[w[u] - 'a'] = u;
        for (int v : g.get(u)) {
            finalParent[v] = u;
            dfs1(v, g, w, finalParent, lca);
        }
        lca[w[u] - 'a'] = origP;
    }

    private static int dfs2(int u, List<List<Integer>> g, int[] res) {
        int size = 1;
        for (int v : g.get(u)) {
            size += dfs2(v, g, res);
        }
        res[u] = size;
        return size;
    }
}
