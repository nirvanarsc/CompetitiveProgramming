package leetcode.weekly_contests.weekly_0_99.weekly_64;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("StringRepeatCanBeUsed")
public class P_753 {

    Set<String> seen;
    StringBuilder ans;

    public String crackSafeDFS(int n, int k) {
        seen = new HashSet<>();
        ans = new StringBuilder();

        final StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            sb.append(0);
        }
        final String start = sb.toString();

        dfs(start, k);
        ans.append(start);
        return new String(ans);
    }

    public void dfs(String node, int k) {
        for (int x = 0; x < k; ++x) {
            final String nei = node + x;
            if (seen.add(nei)) {
                dfs(nei.substring(1), k);
                ans.append(x);
            }
        }
    }

    // Hierholzer's Algorithm
    public String crackSafe(int n, int k) {
        final int nodes = 1 << 4 * n;
        final List<List<int[]>> g = new ArrayList<>(nodes);
        final int[] deg = new int[nodes];
        final int andMask = (1 << 4 * (n - 1)) - 1;
        int edgeIdx = 0;
        for (int i = 0; i < nodes; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < (int) Math.pow(k, n - 1); i++) {
            final String mask = Integer.toString(i, k);
            final char[] zeroPaddedMask = new char[4];
            Arrays.fill(zeroPaddedMask, '0');
            for (int j = zeroPaddedMask.length - 1, idx = mask.length() - 1; idx >= 0; j--, idx--) {
                zeroPaddedMask[j] = mask.charAt(idx);
            }
            int u = 0;
            for (int j = 0, shift = 15; j < 4; j++) {
                final int bits = zeroPaddedMask[j] - '0';
                for (int l = 3; l >= 0; l--, shift--) {
                    if ((bits & (1 << l)) != 0) {
                        u |= 1 << shift;
                    }
                }
            }
            for (int j = 0; j < k; j++) {
                final int v = (u << 4 | j) & andMask;
                g.get(u).add(new int[] { v, j, edgeIdx++ });
                deg[u]++;
            }
        }
        final List<Integer> res = new ArrayList<>();
        final int[] stack = new int[nodes + 1];
        final int[] stack2 = new int[nodes + 1];
        final boolean[] seen = new boolean[edgeIdx];
        int s1 = 0;
        int s2 = 0;
        stack[s1++] = 0;
        stack2[s2++] = -1;
        while (s1 > 0) {
            final int u = stack[s1 - 1];
            final int edge = stack2[s2 - 1];
            boolean flag = false;
            while (deg[u] > 0) {
                final int[] e = g.get(u).get(--deg[u]);
                if (!seen[e[2]]) {
                    seen[e[2]] = true;
                    stack[s1++] = e[0];
                    stack2[s2++] = e[1];
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                if (edge != -1) {
                    res.add(edge);
                }
                s1--;
                s2--;
            }
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            sb.append(0);
        }
        for (int i = res.size() - 1; i >= 0; i--) {
            sb.append(res.get(i));
        }
        return sb.toString();
    }
}
