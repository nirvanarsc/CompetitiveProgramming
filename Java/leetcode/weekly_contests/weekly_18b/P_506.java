package leetcode.weekly_contests.weekly_18b;

import java.util.PriorityQueue;

public class P_506 {

    public String[] findRelativeRanks(int[] nums) {
        final String[] res = new String[nums.length];
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[] { nums[i], i });
        }
        for (int place = 1; !pq.isEmpty(); place++) {
            final int[] curr = pq.remove();
            if (place == 1) {
                res[curr[1]] = "Gold Medal";
            } else if (place == 2) {
                res[curr[1]] = "Silver Medal";
            } else if (place == 3) {
                res[curr[1]] = "Bronze Medal";
            } else {
                res[curr[1]] = String.valueOf(place);
            }
        }
        return res;
    }
}
