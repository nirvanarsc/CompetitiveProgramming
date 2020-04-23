package weekly_contests.weekly_45;

import java.util.HashMap;
import java.util.Map;

public class P_657 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public boolean judgeCircle(String moves) {
        final Map<Character, Integer> map = new HashMap<>();
        map.put('L', 0);
        map.put('R', 1);
        map.put('U', 2);
        map.put('D', 3);
        int x = 0;
        int y = 0;
        for (char c : moves.toCharArray()) {
            x += DIRS[map.get(c)][0];
            y += DIRS[map.get(c)][1];
        }
        return x == 0 && y == 0;
    }
}
