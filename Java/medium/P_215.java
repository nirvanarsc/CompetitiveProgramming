package medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class P_215 {

    // Sort - O(n log n) // O(1)
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // Priority Queue - O(n log k) // O(k)
    public int findKthLargest2(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    // Randomized Quick Select - average O(n) // O(1)
    public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        final Random random = new Random();
        while (low <= high) {
            final int pivotIdx = random.nextInt(high - low + 1) + low;
            final int newPivotIdx = partition(nums, low, high, pivotIdx);
            if (newPivotIdx == k - 1) {
                return nums[newPivotIdx];
            } else if (newPivotIdx > k - 1) {
                high = newPivotIdx - 1;
            } else {
                low = newPivotIdx + 1;
            }
        }
        return low;
    }

    private static int partition(int[] nums, int low, int high, int pivotIdx) {
        final int pivotVal = nums[pivotIdx];
        int newPivotIdx = low;
        swap(nums, pivotIdx, high);
        for (int i = low; i < high; i++) {
            if (nums[i] > pivotVal) {
                swap(nums, i, newPivotIdx++);
            }
        }
        swap(nums, high, newPivotIdx);
        return newPivotIdx;
    }

    private static void swap(int[] nums, int i, int j) {
        final int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
