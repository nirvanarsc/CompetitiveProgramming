package leetcode.weekly_contests.weekly_300_399.weekly_366;

import java.util.Comparator;
import java.util.List;

public class P_2 {

    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        processorTime.sort(Comparator.naturalOrder());
        tasks.sort(Comparator.reverseOrder());
        final int n = processorTime.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                res = Math.max(res, processorTime.get(i) + tasks.get(i * 4 + j));
            }
        }
        return res;
    }
}
