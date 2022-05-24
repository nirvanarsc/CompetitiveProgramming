package leetcode.weekly_contests.weekly_200_299.weekly_279;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_1 {

    public int[] sortEvenOdd(int[] nums) {
        final int n = nums.length;
        final PriorityQueue<Integer> odd = new PriorityQueue<>(Comparator.reverseOrder());
        final PriorityQueue<Integer> even = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = even.remove();
            } else {
                nums[i] = odd.remove();
            }
        }
        return nums;
    }
}
