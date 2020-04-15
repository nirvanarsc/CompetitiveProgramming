package weekly_contests.weekly_54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class P_699 {

    public List<Integer> fallingSquares(int[][] positions) {
        final List<Integer> res = new ArrayList<>();
        final TreeMap<Integer, Integer> startHeight = new TreeMap<>(Collections.singletonMap(0, 0));
        int max = 0;
        for (int[] pos : positions) {
            final int start = pos[0];
            final int end = start + pos[1];
            final Integer from = startHeight.floorKey(start);
            final int height = startHeight.subMap(from, end)
                                          .values()
                                          .stream()
                                          .max(Integer::compare).get() + pos[1];
            max = Math.max(height, max);
            res.add(max);
            // remove interval within [start, end)
            final int lastHeight = startHeight.floorEntry(end).getValue();
            startHeight.put(start, height);
            startHeight.put(end, lastHeight);
            startHeight.subMap(start, false, end, false).clear();
        }
        return res;
    }
}
