package weekly_contests.weekly_115;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_957 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int[] prisonAfterNDays(int[] cells, int N) {
        final Map<Integer, int[]> map = new HashMap<>();
        int[] slow = cells.clone();
        int[] fast = cells.clone();
        int i = 0;
        do {
            slow = next(slow);
            fast = next(next(fast));
            map.put(i++, slow);
        } while (!Arrays.equals(slow, fast));
        return map.get((N - 1) % i);
    }

    private static int[] next(int[] cells) {
        final int[] nextSimulation = new int[8];
        for (int i = 1; i < 7; i++) { nextSimulation[i] = cells[i - 1] == cells[i + 1] ? 1 : 0; }
        return nextSimulation;
    }
}
