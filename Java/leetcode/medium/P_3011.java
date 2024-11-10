package leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P_3011 {

    public boolean canSortArray(int[] nums) {
        final int n = nums.length;
        final int[] other = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            final PriorityQueue<Integer> pq = new PriorityQueue<>();
            while (j < n && Integer.bitCount(nums[i]) == Integer.bitCount(nums[j])) {
                pq.offer(nums[j++]);
            }
            while (!pq.isEmpty()) {
                other[idx++] = pq.remove();
            }
            i = j - 1;
        }
        Arrays.sort(nums);
        return Arrays.equals(nums, other);
    }
}
