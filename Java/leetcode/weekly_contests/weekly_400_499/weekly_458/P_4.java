package leetcode.weekly_contests.weekly_400_499.weekly_458;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("AccessStaticViaInstance")
public class P_4 {

    private static int n;
    private static int[][] edges;
    private static int[][] g;
    private static char[] w;

    public int maxLen(int n, int[][] edges, String label) {
        this.n = n;
        this.edges = edges;
        g = packG();
        w = label.toCharArray();
        int res = 1;
        for (int mask = 0; mask < 1 << n; mask++) {
            if (isOk(mask) && f(mask)) {
                res = Math.max(res, Integer.bitCount(mask));
            }
        }
        return res;
    }

    private static boolean isOk(int mask) {
        int m2 = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                m2 ^= 1 << (w[i] - 'a');
            }
        }
        return Integer.bitCount(m2) < 2;
    }

    private static boolean f(int mask) {
        final int[] f = new int[26];
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                f[w[i] - 'a']++;
            }
        }
        List<Integer> p = new ArrayList<>();
        int odd = -1;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < f[i] / 2; j++) {
                p.add(i);
            }
            if (f[i] % 2 != 0) {
                odd = i;
            }
        }
        while (!p.isEmpty()) {
            final char[] path = new char[2 * p.size() + (odd == -1 ? 0 : 1)];
            int idx = 0;
            for (int u : p) {
                path[idx++] = (char) (u + 'a');
            }
            if (odd != -1) {
                path[idx++] = (char) (odd + 'a');
            }
            for (int i = p.size() - 1; i >= 0; i--) {
                path[idx++] = (char) (p.get(i) + 'a');
            }
            if (dfs(path, 0, -1, 0)) {
                return true;
            }
            p = nextPermutation(p);
        }
        return false;
    }

    private static boolean dfs(char[] path, int idx, int u, int seen) {
        if (idx == path.length) {
            return true;
        }
        if (u == -1) {
            for (int i = 0; i < n; i++) {
                if (w[i] == path[idx]) {
                    if (dfs(path, idx + 1, i, seen | 1 << i)) {
                        return true;
                    }
                }
            }
        } else {
            for (int v : g[u]) {
                if (w[v] == path[idx] && (seen & (1 << v)) == 0) {
                    if (dfs(path, idx + 1, v, seen | 1 << v)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static List<Integer> nextPermutation(List<Integer> perm) {
        int swapIdx = -1;
        final int n = perm.size();
        for (int i = n - 1; i >= 1; i--) {
            if (perm.get(i - 1) < perm.get(i)) {
                swapIdx = i - 1;
                break;
            }
        }
        if (swapIdx == -1) {
            return Collections.emptyList();
        }
        for (int i = n - 1; i >= 1; i--) {
            if (perm.get(i) > perm.get(swapIdx)) {
                Collections.swap(perm, swapIdx, i);
                break;
            }
        }
        Collections.reverse(perm.subList(swapIdx + 1, perm.size()));
        return perm;
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
