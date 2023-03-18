package leetcode.biweekly_contests.biweekly_0_99.biweekly_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class P_1086 {

    public static final int[][] INTS = new int[0][];

    public int[][] highFive(int[][] items) {
        final Map<Integer, List<Integer>> scores = new TreeMap<>();
        for (int[] item : items) {
            scores.computeIfAbsent(item[0], v -> new ArrayList<>()).add(item[1]);
        }
        final List<int[]> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> e : scores.entrySet()) {
            int scoreSum = 0;
            final List<Integer> currScores = e.getValue();
            currScores.sort(Collections.reverseOrder());
            for (int i = 0; i < 5; i++) {
                scoreSum += currScores.get(i);
            }
            res.add(new int[] { e.getKey(), scoreSum / 5 });
        }
        return res.toArray(INTS);
    }
}
