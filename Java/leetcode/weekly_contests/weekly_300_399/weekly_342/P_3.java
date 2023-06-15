package leetcode.weekly_contests.weekly_300_399.weekly_342;

import java.util.TreeSet;

public class P_3 {

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        final int n = nums.length;
        final TreeSet<int[]> min = new TreeSet<>((a, b) -> a[1] == b[1]
                                                           ? Integer.compare(a[0], b[0])
                                                           : Integer.compare(a[1], b[1]));
        final TreeSet<int[]> max = new TreeSet<>((a, b) -> a[1] == b[1]
                                                           ? Integer.compare(a[0], b[0])
                                                           : Integer.compare(b[1], a[1]));
        final int[] res = new int[n - k + 1];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                final int[] rem = { i - k, nums[i - k] };
                max.remove(rem);
                min.remove(rem);
            }
            min.add(new int[] { i, nums[i] });
            max.add(min.pollFirst());
            if (max.size() > x) {
                min.add(max.pollFirst());
            }
            if (i >= k - 1) {
                res[j++] = Math.min(0, max.first()[1]);
            }
        }
        return res;
    }
}
