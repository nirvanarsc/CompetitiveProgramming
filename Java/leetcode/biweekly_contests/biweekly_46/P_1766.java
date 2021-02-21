package leetcode.biweekly_contests.biweekly_46;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1766 {

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int[] getCoprimes(int[] nums, int[][] edges) {
        final List<List<Integer>> coprimes = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            final List<Integer> curr = new ArrayList<>();
            for (int j = 1; j <= 50; j++) {
                if (gcd(i, j) == 1) {
                    curr.add(j);
                }
            }
            coprimes.add(curr);
        }
        final List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        final int[] res = new int[nums.length];
        dfs(0, -1, nums, g, coprimes, new HashMap<>(), 0, res);
        return res;
    }

    private static void dfs(int u, int v, int[] nums, List<List<Integer>> g, List<List<Integer>> cop,
                            Map<Integer, Deque<int[]>> d, int dep, int[] res) {
        int bestDepth = -1;
        int edge = -1;
        for (int cc : cop.get(nums[u] - 1)) {
            final Deque<int[]> get = d.get(cc);
            if (get != null) {
                final int[] curr = get.getFirst();
                if (bestDepth < curr[0]) {
                    bestDepth = curr[0];
                    edge = curr[1];
                }
            }
        }
        res[u] = edge;
        d.computeIfAbsent(nums[u], val -> new ArrayDeque<>()).addFirst(new int[] { dep, u });
        for (int next : g.get(u)) {
            if (next != v) {
                dfs(next, u, nums, g, cop, d, dep + 1, res);
            }
        }
        d.get(nums[u]).removeFirst();
        if (d.get(nums[u]).isEmpty()) {
            d.remove(nums[u]);
        }
    }
}
