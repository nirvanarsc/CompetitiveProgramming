package leetcode.biweekly_contests.biweekly_100_199.biweekly_120;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_3 {

    public long incremovableSubarrayCount(int[] nums) {
        final int n = nums.length;
        if (isIncreasing(nums, n)) {
            return (long) n * (n + 1) / 2;
        }
        final List<Integer> pre = f(nums, 1);
        final List<Integer> suff = f(nums, -1);
        Collections.reverse(suff);
        long res = suff.size() + 1;
        for (int num : pre) {
            int u = lowerBound(suff, num);
            if (u != suff.size() && suff.get(u) == num) {
                u++;
            }
            res += 1 + (suff.size() - u);
        }
        return res;
    }

    private static int lowerBound(List<Integer> list, int target) {
        int lo = 0;
        int hi = list.size();
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (list.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static boolean isIncreasing(int[] nums, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (!(nums[i] < nums[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> f(int[] nums, int dir) {
        final List<Integer> res = new ArrayList<>();
        int i = dir == 1 ? 0 : nums.length - 1;
        while (dir == 1 ? (nums[i] < nums[i + dir]) : (nums[i] > nums[i + dir])) {
            res.add(nums[i]);
            i += dir;
        }
        res.add(nums[i]);
        return res;
    }
}
