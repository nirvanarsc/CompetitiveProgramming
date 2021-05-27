package binarysearch.weekly_39;

import java.util.TreeSet;

public class P_1 {

    public int solve(int[] nums, int k) {
        final TreeSet<Integer> ts = new TreeSet<>((a, b) -> nums[a] == nums[b]
                                                            ? Integer.compare(a, b)
                                                            : Integer.compare(nums[a], nums[b]));
        for (int i = k; i < nums.length; i++) {
            ts.add(i);
        }
        int res = nums[ts.last()] - nums[ts.first()];
        for (int i = k; i < nums.length; i++) {
            ts.remove(i);
            ts.add(i - k);
            res = Math.min(res, nums[ts.last()] - nums[ts.first()]);
        }
        return res;
    }
}
