package leetcode.weekly_contests.weekly_32;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_582 {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        final Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            map.computeIfAbsent(ppid.get(i), v -> new ArrayList<>()).add(pid.get(i));
        }
        final List<Integer> res = new ArrayList<>(Collections.singleton(kill));
        dfs(map, res, kill);
        return res;
    }

    private static void dfs(Map<Integer, List<Integer>> g, List<Integer> res, int curr) {
        if (!g.containsKey(curr)) {
            return;
        }
        for (int next : g.get(curr)) {
            res.add(next);
            dfs(g, res, next);
        }
    }
}
