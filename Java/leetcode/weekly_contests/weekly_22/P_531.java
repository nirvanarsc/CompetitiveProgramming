package leetcode.weekly_contests.weekly_22;

import java.util.HashMap;
import java.util.Map;

public class P_531 {

    public int findLonelyPixel(char[][] picture) {
        final Map<Integer, Integer> rows = new HashMap<>();
        final Map<Integer, Integer> cols = new HashMap<>();
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] == 'B') {
                    rows.merge(i, 1, Integer::sum);
                    cols.merge(j, 1, Integer::sum);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] == 'B'
                    && rows.getOrDefault(i, 0) == 1
                    && cols.getOrDefault(j, 0) == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
