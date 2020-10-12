package leetcode.weekly_contests.weekly_125;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_997 {

    public int findJudge(int N, int[][] trust) {
        final Map<Integer, int[]> g = new HashMap<>();
        for (int i = 0; i < N; i++) {
            g.put(i + 1, new int[] { 0, 0 });
        }
        for (int[] t : trust) {
            g.get(t[0])[1]++;
            g.get(t[1])[0]++;
        }
        for (int i = 0; i < N; i++) {
            final int[] curr = g.get(i + 1);
            if (curr[0] == N - 1 && curr[1] == 0) {
                return i + 1;
            }
        }
        return -1;
    }

    public int findJudgeMap(int N, int[][] trust) {
        final Map<Integer, List<Integer>> t1 = new HashMap<>();
        final Map<Integer, List<Integer>> t2 = new HashMap<>();
        for (int[] tt : trust) {
            t1.computeIfAbsent(tt[1], v -> new ArrayList<>()).add(tt[0]);
            t2.computeIfAbsent(tt[0], v -> new ArrayList<>()).add(tt[1]);
        }
        for (int i = 1; i <= N; i++) {
            if (t1.getOrDefault(i, Collections.emptyList()).size() == N - 1 && !t2.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }
}
