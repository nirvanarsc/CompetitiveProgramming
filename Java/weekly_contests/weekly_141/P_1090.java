package weekly_contests.weekly_141;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P_1090 {

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        final Map<Integer, Integer> used = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            pq.add(new int[] { values[i], labels[i] });
        }
        int res = 0;
        int count = 0;
        while (count < num_wanted && !pq.isEmpty()) {
            final int[] curr = pq.poll();
            if (used.getOrDefault(curr[1], 0) < use_limit) {
                res += curr[0];
                used.merge(curr[1], 1, Integer::sum);
                count++;
            }
        }
        return res;
    }
}
