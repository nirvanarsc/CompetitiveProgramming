package leetcode.weekly_contests.weekly_217;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1673 {

    public int[] mostCompetitive(int[] nums, int k) {
        int remaining = nums.length - k;
        final Deque<Integer> dq = new ArrayDeque<>();
        for (int num : nums) {
            while (!dq.isEmpty() && dq.getLast() > num && remaining > 0) {
                remaining--;
                dq.removeLast();
            }
            dq.addLast(num);
        }
        return dq.stream().limit(k).mapToInt(Integer::intValue).toArray();
    }
}
