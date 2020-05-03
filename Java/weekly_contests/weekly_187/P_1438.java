package weekly_contests.weekly_187;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class P_1438 {

    public int longestSubarray(int[] nums, int limit) {
        int j = 0;
        int res = 0;
        final Deque<Integer> max = new ArrayDeque<>();
        final Deque<Integer> min = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!max.isEmpty() && nums[i] > max.peekLast()) { max.removeLast(); }
            while (!min.isEmpty() && nums[i] < min.peekLast()) { min.removeLast(); }
            max.add(nums[i]);
            min.add(nums[i]);
            if (max.getFirst() - min.getFirst() > limit) {
                if (max.getFirst() == nums[j]) { max.removeFirst(); }
                if (min.getFirst() == nums[j]) { min.removeFirst(); }
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public int longestSubarrayPQ(int[] nums, int limit) {
        int j = 0;
        int res = 0;
        final PriorityQueue<int[]> max = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        final PriorityQueue<int[]> min = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < nums.length; i++) {
            max.add(new int[] { i, nums[i] });
            min.add(new int[] { i, nums[i] });
            while (max.element()[1] - min.element()[1] > limit) {
                j++;
                while (max.element()[0] < j) { max.remove(); }
                while (min.element()[0] < j) { min.remove(); }
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
