package leetcode.weekly_contests.weekly_93;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_871 {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int ans = 0, i = 0;
        while (startFuel < target) {
            while (i < stations.length && startFuel >= stations[i][0]) {
                pq.offer(stations[i++][1]);
            }
            if (pq.isEmpty()) {
                return -1;
            }
            startFuel += pq.remove();
            ans++;
        }
        return ans;
    }
}
