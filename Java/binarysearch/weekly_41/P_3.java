package binarysearch.weekly_41;

import java.util.TreeSet;

public class P_3 {

    public boolean solve(int[] nums, int window, int limit) {
        final TreeSet<Integer> ts = new TreeSet<>((a, b) -> nums[a] == nums[b]
                                                            ? Integer.compare(a, b)
                                                            : Integer.compare(nums[a], nums[b]));
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            ts.add(i);
            if (i >= window) {
                ts.remove(i - window);
            }
            if (nums[ts.last()] - nums[ts.first()] > limit) {
                return false;
            }
        }
        return true;
    }
}
