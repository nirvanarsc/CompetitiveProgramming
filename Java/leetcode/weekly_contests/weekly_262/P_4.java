package leetcode.weekly_contests.weekly_262;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P_4 {

    public int minimumDifference(int[] nums) {
        final int n = nums.length / 2;
        final List<List<Integer>> r = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            r.add(new ArrayList<>());
        }
        for (int mask = 0; mask < (1 << n); mask++) {
            final int bitCount = Integer.bitCount(mask);
            int rSum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    rSum -= nums[n + i];
                } else {
                    rSum += nums[n + i];
                }
            }
            r.get(bitCount).add(rSum);
        }
        for (List<Integer> list : r) {
            list.sort(Comparator.naturalOrder());
        }
        int res = (int) 2e9;
        for (int mask = 0; mask < (1 << n); mask++) {
            final int bitCount = Integer.bitCount(mask);
            int curr = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    curr += nums[i];
                } else {
                    curr -= nums[i];
                }
            }
            final List<Integer> list = r.get(n - bitCount);
            final int idx = lowerBound(list, curr);
            if (idx < list.size()) {
                res = Math.min(res, Math.abs(curr - list.get(idx)));
            }
            if ((idx + 1) < list.size()) {
                res = Math.min(res, Math.abs(curr - list.get(idx + 1)));
            }
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
}
