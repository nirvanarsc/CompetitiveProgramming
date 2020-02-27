package weekly_contests.weekly_136;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1042 {

    public int[] gardenNoAdj(int N, int[][] paths) {
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] path : paths) {
            g.computeIfAbsent(path[0] - 1, v -> new ArrayList<>()).add(path[1] - 1);
            g.computeIfAbsent(path[1] - 1, v -> new ArrayList<>()).add(path[0] - 1);
        }
        final int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            final int[] colors = new int[5];
            for (int neighbour : g.getOrDefault(i, Collections.emptyList())) {
                colors[res[neighbour]] = 1;
            }
            for (int c = 4; c > 0; c--) {
                if (colors[c] == 0) {
                    res[i] = c;
                }
            }
        }
        return res;
    }
}
