package weekly_contests.weekly_125;

import java.util.HashMap;
import java.util.Map;

public class P_997 {

    @SuppressWarnings("MethodParameterNamingConvention")
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
}
