package binarysearch.weekly_49;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class P_3 {

    public int[] solve(int[] nums) {
        final int n = nums.length;
        if (n < 2) {
            return nums;
        }
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(val -> nums[val]));
        final TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            ts.add(i);
            if (isPeak(nums, i)) {
                pq.offer(i);
            }
        }
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            final int curr = pq.remove();
            ts.remove(curr);
            res[i] = nums[curr];
            final Integer lower = ts.lower(curr);
            final Integer higher = ts.higher(curr);
            if (lower != null) {
                add(nums, pq, ts, lower);
            }
            if (higher != null) {
                add(nums, pq, ts, higher);
            }
        }
        return res;
    }

    private static void add(int[] nums, PriorityQueue<Integer> pq, TreeSet<Integer> ts, int idx) {
        final Integer ll = ts.lower(idx);
        final Integer rr = ts.higher(idx);
        if ((ll == null || nums[idx] > nums[ll]) && (rr == null || nums[idx] > nums[rr])) {
            pq.offer(idx);
        }
    }

    private static boolean isPeak(int[] nums, int i) {
        if (i == 0) {
            return nums[0] > nums[1];
        } else if (i == nums.length - 1) {
            return nums[i - 1] < nums[i];
        } else {
            return nums[i - 1] < nums[i] && nums[i] > nums[i + 1];
        }
    }
}
