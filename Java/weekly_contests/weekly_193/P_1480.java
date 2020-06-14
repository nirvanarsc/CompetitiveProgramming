package weekly_contests.weekly_193;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P_1480 {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        final Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.merge(num, 1, Integer::sum);
        }
        final PriorityQueue<Integer> pq = new PriorityQueue<>(freq.values());
        while (!pq.isEmpty() && k > 0) {
            final int remove = pq.remove();
            if (k - remove < 0) {
                pq.add(remove);
                break;
            } else {
                k -= remove;
            }
        }
        return pq.size();
    }
}
