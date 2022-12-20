package leetcode.weekly_contests.weekly_0_99.weekly_86;

import java.util.List;

public class P_841 {

    static int n;
    static List<List<Integer>> g;
    static boolean[] seen;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        n = rooms.size();
        g = rooms;
        seen = new boolean[n];
        dfs(0);
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(int u) {
        if (seen[u]) {
            return;
        }
        seen[u] = true;
        for (int v : g.get(u)) {
            dfs(v);
        }
    }
}
